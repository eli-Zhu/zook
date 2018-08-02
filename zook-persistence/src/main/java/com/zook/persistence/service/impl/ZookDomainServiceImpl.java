package com.zook.persistence.service.impl;

import com.zook.persistence.daointerface.ZookAttributeDAO;
import com.zook.persistence.daointerface.ZookDomainDAO;
import com.zook.persistence.dataobject.ZookDomainDO;
import com.zook.persistence.service.ZookDomainService;
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
public class ZookDomainServiceImpl implements ZookDomainService {

    @Resource
    private ZookDomainDAO zookDomainDAO;

    @Override
    public ZookDomainDO findById(Long id) {
        return zookDomainDAO.findById(id);
    }

    @Override
    public List<ZookDomainDO> findAll() {
        return zookDomainDAO.findAll();
    }

    @Override
    public long insert(ZookDomainDO zookDomain) {
        return zookDomainDAO.insert(zookDomain);
    }
}
