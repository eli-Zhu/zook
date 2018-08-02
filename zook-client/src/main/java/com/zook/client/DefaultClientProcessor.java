package com.zook.client;

import com.zook.client.listener.BaseClientListener;
import org.apache.curator.framework.recipes.cache.NodeCache;
import org.apache.curator.framework.recipes.cache.NodeCacheListener;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import com.zook.client.annotation.ZkAttribute;
import com.zook.client.annotation.ZkResource;
import com.zook.client.common.Constant;
import com.zook.client.context.DefaultContext;
import com.zook.client.listener.impl.DefaultBaseClientListener;
import com.zook.client.zookeeper.ZookeeperConnector;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 客户端执行器
 * Created by Eli on 2018/7/25.
 */
public class DefaultClientProcessor implements BaseClientProcessor, InitializingBean, DisposableBean {

    /**zk address*/
    private String                zkconnect;
    /**上下文环境 */
    private DefaultContext        context;
    /**zk 连接器*/
    private ZookeeperConnector    zookeeperConnector;
    /**监听器 */
    private BaseClientListener    listener;
    /**根路径 */
    private String                root;
    /** 异步通知器 */
    private Executor              taskExecutor;
    /** paths */
    List<String> registList = new ArrayList<String>();

    /**
     * 构建环境
     * @param zkconnect
     * @param root
     */
    private DefaultClientProcessor(String zkconnect, String root) {
        this.root = root;
        this.zkconnect = zkconnect;
        context = new DefaultContext();
    }

    @Override
    public void registerResource(Object obj) throws Exception {
        //解析需注册的path
        registList = resloveResourse(obj);
        //异步前置
        beforeAsync(obj);
        //assembly context
        assemblyContext(registList, obj);
        //注册所有path
        registerPaths(registList);

    }

    @Override
    public void start() {

    }

    @Override
    public void close() {
        if (zookeeperConnector != null) {
            zookeeperConnector.close();
            zookeeperConnector = null;
        }
    }

    @Override
    public void destroy() throws Exception {
        close();
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        if (listener == null) {
            listener = new DefaultBaseClientListener();
        }

        if (root == null || "".equals(root)) {
            root = Constant.ROOT;
        }
    }

    /**
     * 解析注解取得watcher路径
     * @param obj
     * @return
     * @throws Exception
     */
    private List<String> resloveResourse(Object obj) throws Exception{
        List<String> list = new ArrayList<String>();
        Class<? extends Object> clazz=obj.getClass();
        if (clazz.isAnnotationPresent(ZkResource.class)) {
            ZkResource zkResource=clazz.getAnnotation(ZkResource.class);
            String resource = zkResource.resource();
            String domain = zkResource.domain();
            String prefixPath = getPrefix(domain, resource);
            Field[] fields=clazz.getDeclaredFields();

            for(Field field : fields){
                if (field.isAnnotationPresent(ZkAttribute.class)) {
                    ZkAttribute dAttribute=  field.getAnnotation(ZkAttribute.class);
                    String name = dAttribute.name();
                    String path = prefixPath + Constant.BACK_SLASH + name;
                    list.add(path);
                }
            }
        }
        return list;
    }
    /**
     * 获取路径前缀 /根/domain/resource
     * @param domainName
     * @param id
     * @return
     */
    private String getPrefix(String domainName, String id) {
        if (!root.startsWith(Constant.BACK_SLASH)) {
            root = Constant.BACK_SLASH + root;
        }
        if (!domainName.startsWith(Constant.BACK_SLASH)) {
            domainName = Constant.BACK_SLASH + domainName;
        }
        if (!id.startsWith(Constant.BACK_SLASH)) {
            id = Constant.BACK_SLASH + id;
        }
        return root + domainName + id;
    }

    /**
     * 异步前置方法
     * @param obj
     */
    private void beforeAsync(Object obj){
        getTaskExecutor().execute(new Runnable() {
            @Override
            public void run() {
                try{
                    listener.onBeforeWatching(obj);
                }catch(Exception e){

                }
            }
        });
    }
    /**
     * 异步后置
     */
    private void afterAsync(String path, byte[] content) {
        //async
        getTaskExecutor().execute(new Runnable() {
            @Override
            public void run() {
                try {
                    listener.onAfterWatching(context, path, content);
                } catch (Exception e) {

                }
            }
        });
    }

    /**
     * 放入缓存
     * @param paths
     * @param obj
     */
    private void assemblyContext(List<String> paths, Object obj){
        for (String path : paths) {
            context.getMap().put(path, obj);
        }
    }
    /**
     * 取得zk
     * @return
     */
    private ZookeeperConnector getZookeeper() {
        if (zookeeperConnector == null) {
            initZookeeper();
        }
        return zookeeperConnector;
    }
    /**
     * 初始化zk
     */
    private void initZookeeper() {
        zookeeperConnector = ZookeeperConnector.getInstance(zkconnect);
        zookeeperConnector.start();
    }
    /**
     * 注册
     * @param paths
     */
    private void registerPaths(List<String> paths)throws Exception{
        for(String path : paths){
            final NodeCache cache =new NodeCache(getZookeeper().getZkClient(),path,false);
            cache.start(true);
            cache.getListenable().addListener(new NodeCacheListener() {
                @Override
                public void nodeChanged() throws Exception {
                    afterAsync(cache.getCurrentData().getPath(), cache.getCurrentData().getData());
                }
            });
        }
    }
    /**
     * 获取任务执行器
     *
     * @return
     */
    public Executor getTaskExecutor() {
        if (taskExecutor == null) {
            taskExecutor = Executors.newCachedThreadPool(new NamedThreadFactory("zook", true));
        }
        return taskExecutor;
    }

    /**
     * 自定义线程工厂
     */
    private  class NamedThreadFactory implements ThreadFactory{
        private final AtomicInteger mThreadNum=new AtomicInteger(1);

        private final String        mPrefix;

        private final boolean       mDaemo;

        private final ThreadGroup   mGroup;

        public NamedThreadFactory(String prefix, boolean daemo) {
            mPrefix = prefix + "-thread-";
            mDaemo = daemo;
            SecurityManager s = System.getSecurityManager();
            mGroup = (s == null) ? Thread.currentThread().getThreadGroup() : s.getThreadGroup();
        }
        @Override
        public Thread newThread(Runnable r) {
            String name =mPrefix +mThreadNum.getAndIncrement();
            Thread ret =new Thread(mGroup,r,name,0);
            ret.setDaemon(mDaemo);
            return ret;
        }
    }

}
