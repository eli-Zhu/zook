package com.zook.persistence.service.impl;

import com.zook.persistence.daointerface.ZookResourceDAO;
import com.zook.persistence.dataobject.ZookResourceDO;
import com.zook.persistence.service.ZookResourceService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 *
 * Created by Eli on 2018/8/2.
 */
@Service
@Transactional
public class ZookResourceServiceImpl implements ZookResourceService {

    @Resource
    private ZookResourceDAO zookResourceDAO;

    @Override
    public ZookResourceDO findById(Long id) {
        return zookResourceDAO.findById(id);
    }

    @Override
    public List<ZookResourceDO> findAll() {
        return zookResourceDAO.findAll();
    }

    @Override
    public long insert(ZookResourceDO zookResource) {
        return zookResourceDAO.insert(zookResource);
    }

    @Override
    public int deleteByDomainId(Long domainId) {
        return zookResourceDAO.deleteByDomainId(domainId);
    }
}
