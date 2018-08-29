package com.zook.persistence.service;

import com.zook.persistence.dataobject.ZookResourceDO;

import java.util.List;

/**
 *
 * Created by Eli on 2018/8/2.
 */
public interface ZookResourceService {

    ZookResourceDO findById(Long id);

    List<ZookResourceDO> findAll();

    long insert(ZookResourceDO zookResource);

    int deleteByDomainId(Long domainId);
}
