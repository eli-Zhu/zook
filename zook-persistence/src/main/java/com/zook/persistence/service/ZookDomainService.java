package com.zook.persistence.service;

import com.zook.persistence.dataobject.ZookDomainDO;

import java.util.List;

/**
 *
 * Created by Eli on 2018/8/2.
 */
public interface ZookDomainService {

    ZookDomainDO findById(Long id);

    List<ZookDomainDO> findAll();

    long insert(ZookDomainDO zookDomain);
}
