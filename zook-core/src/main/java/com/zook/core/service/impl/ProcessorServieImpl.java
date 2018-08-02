package com.zook.core.service.impl;

import com.zook.core.common.Constant;
import com.zook.core.exception.ZookException;
import com.zook.core.service.ProcessorServie;
import com.zook.core.zookeeper.ZookeeperConnector;
import org.apache.zookeeper.data.Stat;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.List;

/**
 * 处理器
 * Created by Eli on 2018/7/18.
 */
@Service
public class ProcessorServieImpl implements ProcessorServie {

    @Resource
    private ZookeeperConnector zookeeperConnector;

    @Override
    public Boolean create(String path, String value) {
        Boolean result=true;
        try{
            result=zookeeperConnector.create(getRootPath(path),value);
        }catch (Exception e){
            throw new ZookException("create zook node fail");
        }
        return result;
    }

    @Override
    public String getData(String path) {
        String result = null;

        try {
            result = zookeeperConnector.getData(getRootPath(path));
        } catch (Exception e) {
            throw new ZookException("getData zook node fail:"+path);
        }
        return result;
    }

    @Override
    public Boolean setData(String path, String value) {
        boolean result = true;
        Stat stat = null;
        try {
            stat = zookeeperConnector.setData(getRootPath(path));
        } catch (Exception e) {
            throw new ZookException("setData zook node fail:"+path+",value:"+value);
        }
        if (stat == null) {
            result = false;
        }
        return result;
    }

    @Override
    public Boolean setData(String oldPath, String newPath, String value) {
        oldPath = getZkPath(oldPath);
        newPath = getZkPath(newPath);
        boolean result = true;
        if (oldPath.equals(newPath)) {
            result = setData(newPath, value);
        } else {
            cascadeUpdate(oldPath, newPath, value);
            cascadeDelete(oldPath);
        }
        return result;
    }

    @Override
    public List<String> getChildrenNodes(String path) {
        List<String> list = null;
        try {
            list = zookeeperConnector.getChildren(getRootPath(path));
        } catch (Exception e) {
            throw new ZookException("getChildrenNodes zook node fail:"+path);
        }
        return list;
    }

    @Override
    public Boolean delete(String path) {
        boolean result = true;
        try {
            result = zookeeperConnector.delete(getRootPath(path));
        } catch (Exception e) {
            throw new ZookException("delete zook node fail:"+path);
        }
        return result;
    }

    @Override
    public void cascadeDelete(String path) {
        path = getZkPath(path);
        List<String> childList = getChildrenNodes(path);
        if (CollectionUtils.isEmpty(childList)) {
            delete(path);
        } else {
            for (String child : childList) {
                cascadeDelete(path + Constant.BACK_SLASH + child);
            }
            delete(path);
        }
    }

    /**
     * 获取路径
     * @param path
     */
    private String getRootPath(String path){
        String root=zookeeperConnector.getRoot();
        if(!root.startsWith(Constant.BACK_SLASH)){
            root=Constant.BACK_SLASH+root;
        }
        return root + path;
    }

    /**
     *
     * @param path
     * @return
     */
    private String getZkPath(String path) {
        if (!path.startsWith(Constant.BACK_SLASH)) {
            path = Constant.BACK_SLASH + path;
        }
        return path;
    }

    /**
     *
     * @param oldPath
     * @param newPath
     * @param value
     */
    private void cascadeUpdate(String oldPath, String newPath, String value) throws ZookException {
        List<String> childList = getChildrenNodes(oldPath);
        if (CollectionUtils.isEmpty(childList)) {
            create(newPath, value);
        } else {
            create(newPath, value);
            for (String child : childList) {
                String data = getData(oldPath + Constant.BACK_SLASH + child);
                cascadeUpdate(oldPath + Constant.BACK_SLASH + child, newPath + Constant.BACK_SLASH + child, data);
            }
        }
    }

}
