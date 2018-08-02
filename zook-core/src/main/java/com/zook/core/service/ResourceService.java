package com.zook.core.service;

import com.zook.core.exception.ZookException;
import com.zook.core.vo.ResourceVO;

import java.util.List;

/**
 * Created by Eli on 2018/8/2.
 */
public interface ResourceService {
    /**
     * create resource
     * @param resourceVO
     * @return
     * @throws ZookException
     */
    boolean createResource(ResourceVO resourceVO) throws ZookException;

    /**
     * delete resource
     * @param id
     * @return
     * @throws ZookException
     */
    boolean deleteResource(long id) throws ZookException;

    /**
     * update resource
     * @param resourceVO
     * @return
     * @throws ZookException
     */
    boolean updateResource(ResourceVO resourceVO) throws ZookException;

    /**
     *
     * @param id
     * @return
     * @throws ZookException
     */
    ResourceVO findById(long id) throws ZookException;

    /**
     *
     * @param domainId
     * @return
     * @throws ZookException
     */
    List<ResourceVO> findByDomainId(long domainId) throws ZookException;

    /**
     *
     * @param domainId
     * @return
     * @throws ZookException
     */
    int deleteBydomainId(long domainId) throws ZookException;
}
