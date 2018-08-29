package com.zook.persistence.service.impl;

import com.zook.persistence.daointerface.ZookAttributeDAO;
import com.zook.persistence.dataobject.ZookAttributeDO;
import com.zook.persistence.service.ZookAttributeService;
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
public class ZookAttributeServiceImpl implements ZookAttributeService{
    @Resource
    private ZookAttributeDAO zookAttributeDAO;

    @Override
    public ZookAttributeDO findById(Long id) {

        return zookAttributeDAO.findById(id);
    }

    @Override
    public List<ZookAttributeDO> findAll() {
        return zookAttributeDAO.findAll();
    }

    @Override
    public long insert(ZookAttributeDO zookAttribute) {
        return zookAttributeDAO.insert(zookAttribute);
    }

    @Override
    public int deleteByResourceId(Long resourceId) {
        return zookAttributeDAO.deleteByResourceId(resourceId);
    }
}
