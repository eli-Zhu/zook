package com.zook.core.service.impl;

import com.zook.core.common.Constant;
import com.zook.core.exception.ZookException;
import com.zook.core.mapper.ZookMapper;
import com.zook.core.service.AttributeService;
import com.zook.core.service.DomainService;
import com.zook.core.service.ProcessorService;
import com.zook.core.service.ResourceService;
import com.zook.core.vo.DomainVO;
import com.zook.core.vo.ResourceVO;
import com.zook.persistence.dataobject.ZookDomainDO;
import com.zook.persistence.operation.DomainQueryDO;
import com.zook.persistence.service.ZookDomainService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    @Transactional(rollbackFor = ZookException.class)
    @Override
    public Boolean createDomain(DomainVO domainVO) {
        Boolean isCreated=true;
        //校验
        Assert.notNull(domainVO, "domainVO can not be null");
        try {
            String path=getDomainPath(domainVO);
            String value=domainVO.getDomainValue();
            zookDomainService.insert(ZookMapper.domainVO2DO(domainVO));
            //创建节点
            isCreated=processorServie.create(path,value);
        }catch(Exception e){
            throw new ZookException("创建域节点异常");
        }
        return isCreated;
    }

    @Transactional(rollbackFor = ZookException.class)
    @Override
    public Boolean deleteDomain(Long id)  {
        Boolean isDeleted=false;
        try {
            DomainVO domain = findById(id);
            Assert.notNull(domain, "domain can not be null");
            String path = getDomainPath(domain);
            //级联删除
            cascadeDelete(domain);
            isDeleted=processorServie.cascadeDelete(path);
        }catch(Exception e){
            throw new ZookException("级联删除所有节点失败");
        }
        return isDeleted;
    }

    @Transactional(rollbackFor = ZookException.class)
    @Override
    public Boolean updateDomain(DomainVO domainVO)  {
        return false;
    }

    @Override
    public Map pageQuery(DomainQueryDO domainQuery) {

        return zookDomainService.pageQuery(domainQuery);
    }

    @Override
    public DomainVO findById(Long domainId)  {
        ZookDomainDO zookDomain=zookDomainService.findById(domainId);
        return ZookMapper.domainDO2VO(zookDomain);
    }

    @Override
    public DomainVO findByPath(String path) {
        return null;
    }

    /**
     * 获取域资源路径
     * @param domainVO
     * @return
     */
    private String getDomainPath(DomainVO domainVO){
        String path=domainVO.getDomainPath();
        if(StringUtils.isBlank(path)){
            return StringUtils.EMPTY;
        }

        if(!path.startsWith(Constant.BACK_SLASH)){
            path = Constant.BACK_SLASH + path;
        }
        return path;
    }

    /**
     * 级联删除resources和attributes
     * @param domainVO
     * @throws ZookException
     */
    private void cascadeDelete(DomainVO domainVO) throws ZookException {

        Long domainId = domainVO.getId();
        //delete domain
        zookDomainService.deleteById(domainId);

        List<ResourceVO> resources = resourceService.findByDomainId(domainId);
        if (!CollectionUtils.isEmpty(resources)) {
            //delete resources
            resourceService.deleteBydomainId(domainId);
            for (ResourceVO resourceVO : resources) {
                //delete attributes
                attributeService.deleteByResourceId(resourceVO.getId());
            }
        }
    }
}
