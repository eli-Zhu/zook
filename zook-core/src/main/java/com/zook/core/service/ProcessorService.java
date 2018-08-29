package com.zook.core.service;

import java.util.List;

/**
 * 处理服务器
 * Created by Eli on 2018/7/12.
 */
public interface ProcessorService extends BaseService{

    /**
     * create zookeeper node with given value
     * @param path
     * @param value
     * @return
     */
    Boolean create(String path,String value);

    /**
     * get the zoookeeper node content
     * @param path
     * @return
     */
    String getData(String path);

    /**
     *  set zookeeper node data with given value
     * @param path
     * @param value
     * @return
     */
    Boolean setData(String path,String value);

    /**
     *
     * @param oldPath
     * @param newPath
     * @param value
     * @return
     */
    Boolean setData(String oldPath,String newPath,String value);

    /**
     * get the node childrens
     * @param path
     * @return
     */
    List<String> getChildrenNodes(String path);

    /**
     *  delete the zookeeper node
     * @param path
     * @return
     */
    Boolean delete(String path);

    /**
     * cascade delete(串联删除)
     * @param path
     */
    Boolean cascadeDelete(String path);
}
