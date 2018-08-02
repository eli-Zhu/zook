package com.zook.client.zookeeper;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.imps.CuratorFrameworkState;
import org.apache.curator.retry.RetryNTimes;
import com.zook.client.common.Constant;

/**
 * 连接器
 * Created by Eli on 2018/7/25.
 */
public class ZookeeperConnector {
    /***/
    private static ZookeeperConnector zookConnector      = null;
    /**zook客户端*/
    private CuratorFramework          client;
    /**同步*/
    private static String             sync               = "sync";

    /**
     *创建连接器
     * @param zkConnect
     */
    private ZookeeperConnector(String zkConnect){
        initClient(zkConnect);
    }

    /**
     * 获取客户端
     * @return
     */
    public CuratorFramework getZkClient() {
        return client;
    }

    /**
     * 开启
     */
    public synchronized void start() {
        if (client.getState() == CuratorFrameworkState.LATENT) {
            client.start();
        }
    }

    /**
     * 关闭
     */
    public void close() {
        if (client != null) {
            client.close();
            zookConnector = null;
        }
    }

    /**
     * 获取结点数据
     * @param path
     * @return
     */
    public byte[] getData(String path) {
        byte[] result = null;
        try {
            result = client.getData().forPath(path);
        } catch (Exception e) {

        }
        return result;
    }
    /**
     *
     * @param zkConnect
     * @return
     */
    public static ZookeeperConnector getInstance(String zkConnect){
        synchronized (ZookeeperConnector.class) {
            if (zookConnector == null) {
                zookConnector = new ZookeeperConnector(zkConnect);
            }
        }
        return zookConnector;
    }

    /**
     * 初始化客户端
     * @param zkConnect
     */
    private void initClient(String zkConnect){
        client= CuratorFrameworkFactory.newClient(zkConnect,  Constant.DEFAULT_TIMEOUT,
                Constant.DEFAULT_TIMEOUT,new RetryNTimes(Constant.MAX_RETRY_TIMES, Constant.DEFAULT_TIMEOUT));

    }
}
