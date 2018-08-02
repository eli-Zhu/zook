package com.zook.persistence.service;

import com.zook.persistence.dataobject.ZookAttributeDO;

import java.util.List;

/**
 *
 * Created by Eli on 2018/8/2.
 */
public interface ZookAttributeService {

    ZookAttributeDO findById(Long id);

    List<ZookAttributeDO> findAll();

    long insert(ZookAttributeDO zookAttribute);
}
