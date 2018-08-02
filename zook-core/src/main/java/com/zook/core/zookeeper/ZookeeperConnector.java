package com.zook.core.zookeeper;

import com.zook.core.common.Constant;
import com.zook.core.exception.ZookException;
import org.apache.commons.lang3.StringUtils;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.imps.CuratorFrameworkState;
import org.apache.curator.retry.RetryNTimes;
import org.apache.zookeeper.data.Stat;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.List;

/**
 * 主连接器
 * Created by Eli on 2018/7/12.
 */
@Service
public class ZookeeperConnector implements InitializingBean, DisposableBean {
    /**链接地址*/
    private String zkConnect;
    /**跟结点*/
    private String root;
    /**apache zookeeper client*/
    private CuratorFramework zkClient;


    @Override
    public void afterPropertiesSet()  {
        Assert.isTrue(StringUtils.isBlank(zkConnect),"zkConnect not empty");
        try{
            zkClient= CuratorFrameworkFactory.newClient(zkConnect, Constant.DEFAULT_TIMEOUT,
                    Constant.DEFAULT_TIMEOUT,new RetryNTimes(Constant.MAX_RETRY_TIMES,Constant.DEFAULT_TIMEOUT));
            //初始化
            if(CuratorFrameworkState.LATENT==zkClient.getState()){
                zkClient.start();
            }
            if(StringUtils.isEmpty(root)){
                root=Constant.ROOT;
            }
        }catch(Exception e){
            throw  new ZookException("init zookeeper start fail");
        }
    }

    /**
     * 创建结点
     * @param path 路径
     * @return
     * @throws Exception
     */
    public boolean create(String path) {
        Boolean created=true;
        try {
            String result = zkClient.create().forPath(path);
            if(StringUtils.isBlank(result)){
                created=false;
            }
        }catch(Exception e){
            created=false;
        }
        return created;
    }

    /**
     * 创建结点
     * @param path 路径
     * @param value 结点上的值
     * @return
     * @throws Exception
     */
    public boolean create(String path,String value) {
        Boolean created=true;
        if(StringUtils.isBlank(value)){
            create(path);
        }
        try{
            String result=zkClient.create().forPath(path,value.getBytes(Constant.UTF8));
            if(StringUtils.isBlank(result)){
                created=false;
            }
        }catch(Exception e){
            created=false;
        }
        return created;
    }

    /**
     * 获取结点数据
     * @param path
     * @return
     */
    public String getData(String path){
        String result=StringUtils.EMPTY;
        try{
            byte[] resultByte=zkClient.getData().forPath(path);
            result=new String(resultByte,Constant.UTF8);
        }catch(Exception e){

        }
        return result;
    }

    /**
     * 设置结点的数据
     * @param path
     * @return
     * @throws Exception
     */
    public Stat setData(String path) {
        Stat stat = null;
        try {
            stat = zkClient.setData().forPath(path);
        } catch (Exception e) {

        }
        return stat;
    }

    /**
     * 设置结点的数据
     * @param path
     * @param value
     * @return
     * @throws Exception
     */
    public Stat setData(String path, String value)  {
        Stat stat = null;
        try {
            stat = zkClient.setData().forPath(path, value.getBytes(Constant.UTF8));
        } catch (Exception e) {

        }
        return stat;
    }

    /**
     * 获取结点下的所有子结点
     * @param path
     * @return
     */
    public List<String> getChildren(String path){
        List<String> childrens=new ArrayList<String>();
        try {
            childrens=zkClient.getChildren().forPath(path);
        }catch(Exception e){

        }
        return childrens;
    }

    /**
     * 删除结点
     * @param path
     * @return
     * @throws Exception
     */
    public boolean delete(String path)  {
        try {
            zkClient.delete().forPath(path);
        } catch (Exception e) {

        }
        return true;
    }

    @Override
    public void destroy() throws Exception {
        if(zkClient!=null){
            zkClient.close();
        }
    }

    public void setZkConnect(String zkConnect) {
        this.zkConnect = zkConnect;
    }

    public void setRoot(String root) {
        this.root = root;
    }

    public String getRoot() {
        return root;
    }
}
