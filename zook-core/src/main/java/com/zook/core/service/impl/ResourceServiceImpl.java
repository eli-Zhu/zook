package com.zook.core.service.impl;

import com.zook.core.exception.ZookException;
import com.zook.core.service.AttributeService;
import com.zook.core.service.DomainService;
import com.zook.core.service.ProcessorService;
import com.zook.core.service.ResourceService;
import com.zook.core.vo.ResourceVO;
import com.zook.persistence.service.ZookResourceService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 *
 * Created by Eli on 2018/8/2.
 */
@Service
public class ResourceServiceImpl implements ResourceService {

    /** 域名服务 */
    @Resource
    private DomainService domainService;

    /** 属性服务 */
    @Resource
    private AttributeService attributeService;

    /** zk服务 */
    @Resource
    private ProcessorService processorService;

    /** 资源dao */
    @Resource
    private ZookResourceService zookResourceService;
    @Override
    public boolean createResource(ResourceVO resourceVO) throws ZookException {
        return false;
    }

    @Override
    public boolean deleteResource(long id) throws ZookException {
        return false;
    }

    @Override
    public boolean updateResource(ResourceVO resourceVO) throws ZookException {
        return false;
    }

    @Override
    public ResourceVO findById(long id) throws ZookException {
        return null;
    }

    @Override
    public List<ResourceVO> findByDomainId(long domainId) throws ZookException {
        return null;
    }

    @Override
    public int deleteBydomainId(long domainId) throws ZookException {
        return 0;
    }
}
