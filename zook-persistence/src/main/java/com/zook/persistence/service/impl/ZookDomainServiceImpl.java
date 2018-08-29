package com.zook.persistence.service.impl;

import com.zook.persistence.daointerface.ZookAttributeDAO;
import com.zook.persistence.daointerface.ZookDomainDAO;
import com.zook.persistence.dataobject.ZookDomainDO;
import com.zook.persistence.operation.DomainQueryDO;
import com.zook.persistence.service.ZookDomainService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    @Override
    public int deleteById(Long id) {
        return zookDomainDAO.deleteById(id);
    }

    @Override
    public Map pageQuery(DomainQueryDO domainQuery) {
        Map<String, Object> resutMap = new HashMap<String, Object>();
        resutMap.put("total", zookDomainDAO.count(domainQuery));//总数
        resutMap.put("rows", zookDomainDAO.queryByParam(domainQuery));//数据
        return resutMap;
    }
}
