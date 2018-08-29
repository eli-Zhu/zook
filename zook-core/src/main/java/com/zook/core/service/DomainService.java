package com.zook.core.service;

import com.zook.core.exception.ZookException;
import com.zook.core.vo.DomainVO;
import com.zook.persistence.operation.DomainQueryDO;

import java.util.List;
import java.util.Map;

/**
 * Created by Eli on 2018/8/2.
 */
public interface DomainService {

    /**
     * create domain
     * @param domainVO
     * @return
     */
    Boolean createDomain(DomainVO domainVO) ;

    /**
     * delete domain
     * @param id
     * @return
     */
    Boolean deleteDomain(Long id) ;

    /**
     * set domain node value
     * @param domainVO
     * @return
     */
    Boolean updateDomain(DomainVO domainVO) ;

    /**
     * 分页查询
     * @param domainQuery
     * @return
     */
    Map pageQuery(DomainQueryDO domainQuery);

    /**
     *
     * @param domainId
     * @return
     */
    DomainVO findById(Long domainId) ;

    /**
     *
     * @param path
     * @return
     */
    DomainVO findByPath(String path) ;
}
