package com.zook.core.mapper;

import com.zook.core.vo.DomainVO;
import com.zook.persistence.dataobject.ZookDomainDO;
import org.apache.commons.lang3.StringUtils;

/**
 * 模型转换
 * Created by Eli on 2018/8/3.
 */
public class ZookMapper {
    private ZookMapper(){

    }

    /**
     * 域模型转换vo2do
     * @param domainVO
     * @return
     */
    public static ZookDomainDO domainVO2DO(DomainVO domainVO) {
        ZookDomainDO zookDomain=null;
        if(domainVO!=null){
            zookDomain=new ZookDomainDO();
            zookDomain.setId(domainVO.getId());
            zookDomain.setDomainName(isNotEmpty(domainVO.getDomainName()));
            zookDomain.setDomainPath(isNotEmpty(domainVO.getDomainPath()));
            zookDomain.setDomainValue(isNotEmpty(domainVO.getDomainValue()));
            zookDomain.setIsValid(domainVO.getIsValid());
            zookDomain.setRemark(isNotEmpty(domainVO.getRemark()));
            zookDomain.setCreateTime(domainVO.getCreateTime());
            zookDomain.setUpdateTime(domainVO.getUpdateTime());
            zookDomain.setOperator(isNotEmpty(domainVO.getOperator()));
        }
        return zookDomain;
    }

    /**
     * 域模型转换do2vo
     * @param zookDomain
     * @return
     */
    public static DomainVO domainDO2VO(ZookDomainDO zookDomain) {
        DomainVO domain=null;
        if(zookDomain!=null){
            domain=new DomainVO();
            domain.setId(zookDomain.getId());
            domain.setDomainName(zookDomain.getDomainName());
            domain.setDomainPath(zookDomain.getDomainPath());
            domain.setDomainValue(zookDomain.getDomainValue());
            domain.setIsValid(zookDomain.getIsValid());
            domain.setRemark(zookDomain.getRemark());
            domain.setCreateTime(zookDomain.getCreateTime());
            domain.setUpdateTime(zookDomain.getUpdateTime());
            domain.setOperator(zookDomain.getOperator());
        }
        return domain;
    }

    /**
     *
     * @param str
     * @return
     */
    public static String isNotEmpty(String str){
        return StringUtils.isBlank(str)?"":str;
    }
}
