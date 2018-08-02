package com.zook.core.service;

import com.zook.core.exception.ZookException;
import com.zook.core.vo.AttributeVO;

import java.util.List;

/**
 * Created by Eli on 2018/8/2.
 */
public interface AttributeService {
    /**
     * 新增属性
     * @param attributeVO
     * @return
     * @throws ZookException
     */
    boolean createAttribute(AttributeVO attributeVO) throws ZookException;

    /**
     * 删除属性
     * @param id
     * @return
     * @throws ZookException
     */
    boolean deleteAttribute(long id) throws ZookException;

    /**
     * 更新属性
     * @param attributeVO
     * @return
     * @throws ZookException
     */
    boolean updateAttribute(AttributeVO attributeVO) throws ZookException;

    /**
     * 远程调用更新属性
     * @param attributeVO
     * @return
     * @throws ZookException
     */
//    boolean rpcReceive(DrmConditionVO attributeVO) throws ZookException;

    /**
     *
     * @param id
     * @return
     * @throws ZookException
     */
    AttributeVO findById(long id) throws ZookException;

    /**
     *
     * @param resourceId
     * @return
     * @throws ZookException
     */
    List<AttributeVO> findByResourceId(long resourceId) throws ZookException;

    /**
     *
     * @param resourceId
     * @return
     * @throws ZookException
     */
    int deleteByResourceId(long resourceId) throws ZookException;
}
