package com.zook.core.service.impl;

import com.zook.core.exception.ZookException;
import com.zook.core.service.AttributeService;
import com.zook.core.service.DomainService;
import com.zook.core.service.ProcessorService;
import com.zook.core.service.ResourceService;
import com.zook.core.vo.DomainVO;
import com.zook.persistence.service.ZookDomainService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 *
 * Created by Eli on 2018/8/2.
 */
@Service
public class DomainServiceImpl implements DomainService{
    /** zk服务 */
    @Resource
    private ProcessorService processorServie;

    /** 资源服务 */
    @Resource
    private ResourceService resourceService;

    /** 属性服务 */
    @Resource
    private AttributeService attributeService;

    /** domain dao */
    @Resource
    private ZookDomainService zookDomainService;

    @Override
    public boolean createDomain(DomainVO domainVO) throws ZookException {

        return false;
    }

    @Override
    public boolean deleteDomain(long id) throws ZookException {
        return false;
    }

    @Override
    public boolean updateDomain(DomainVO domainVO) throws ZookException {
        return false;
    }

    @Override
    public DomainVO findById(long domainId) throws ZookException {
        return null;
    }

    @Override
    public DomainVO findByPath(String path) throws ZookException {
        return null;
    }
}
