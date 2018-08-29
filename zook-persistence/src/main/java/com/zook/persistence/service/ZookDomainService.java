package com.zook.persistence.service;

import com.zook.persistence.dataobject.ZookDomainDO;
import com.zook.persistence.operation.DomainQueryDO;

import java.util.List;
import java.util.Map;

/**
 *
 * Created by Eli on 2018/8/2.
 */
public interface ZookDomainService {

    ZookDomainDO findById(Long id);

    List<ZookDomainDO> findAll();

    long insert(ZookDomainDO zookDomain);

    int deleteById(Long id);

    Map pageQuery(DomainQueryDO domainQuery);
}
