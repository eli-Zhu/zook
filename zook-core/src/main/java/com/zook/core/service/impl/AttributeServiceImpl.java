package com.zook.core.service.impl;

import com.zook.core.exception.ZookException;
import com.zook.core.service.AttributeService;
import com.zook.core.service.DomainService;
import com.zook.core.service.ProcessorService;
import com.zook.core.service.ResourceService;
import com.zook.core.vo.AttributeVO;
import com.zook.persistence.service.ZookAttributeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 *
 * Created by Eli on 2018/8/2.
 */
@Service
public class AttributeServiceImpl implements AttributeService {

    /** zk服务 */
    @Resource
    private ProcessorService processorServie;

    /** 域名服务 */
    @Resource
    private DomainService domainService;

    /** 资源服务 */
    @Resource
    private ResourceService resourceService;
    /** 属性dao */
    @Resource
    private ZookAttributeService zookAttributeService;

    @Override
    public boolean createAttribute(AttributeVO attributeVO) throws ZookException {
        return false;
    }

    @Override
    public boolean deleteAttribute(long id) throws ZookException {
        return false;
    }

    @Override
    public boolean updateAttribute(AttributeVO attributeVO) throws ZookException {
        return false;
    }

    @Override
    public AttributeVO findById(long id) throws ZookException {
        return null;
    }

    @Override
    public List<AttributeVO> findByResourceId(long resourceId) throws ZookException {
        return null;
    }

    @Override
    public int deleteByResourceId(long resourceId) throws ZookException {
        return 0;
    }
}
