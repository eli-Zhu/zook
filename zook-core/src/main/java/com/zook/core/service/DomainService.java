package com.zook.core.service;

import com.zook.core.exception.ZookException;
import com.zook.core.vo.DomainVO;

/**
 * Created by Eli on 2018/8/2.
 */
public interface DomainService {

    /**
     * create domain
     * @param domainVO
     * @return
     * @throws ZookException
     */
    boolean createDomain(DomainVO domainVO) throws ZookException;

    /**
     * delete domain
     * @param id
     * @return
     * @throws ZookException
     */
    boolean deleteDomain(long id) throws ZookException;

    /**
     * set domain node value
     * @param domainVO
     * @return
     * @throws ZookException
     */
    boolean updateDomain(DomainVO domainVO) throws ZookException;

    /**
     * query domain
     * @param domainVO
     * @param page
     * @param pageSize
     * @return
     * @throws ZookException
     */
//    PageList<DomainVO> pageQuery(DomainVO domainVO, int page, int pageSize) throws ZookException;

    /**
     *
     * @param domainId
     * @return
     * @throws ZookException
     */
    DomainVO findById(long domainId) throws ZookException;

    /**
     *
     * @param path
     * @return
     * @throws ZookException
     */
    DomainVO findByPath(String path) throws ZookException;
}
