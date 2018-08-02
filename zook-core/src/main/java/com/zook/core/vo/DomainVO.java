package com.zook.core.vo;

/**
 * 资源域模型
 * Created by Eli on 2018/8/2.
 */
public class DomainVO extends ZookBaseVO{
    /**  */
    private static final long serialVersionUID = -8577622463556767304L;

    /**主键*/
    private Long              id;
    /**域名描述*/
    private String            domainName;
    /**域路径*/
    private String            domainPath;
    /**域值*/
    private String            domainValue;
    /** 操作人 */
    private String            operator;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDomainName() {
        return domainName;
    }

    public void setDomainName(String domainName) {
        this.domainName = domainName;
    }

    public String getDomainPath() {
        return domainPath;
    }

    public void setDomainPath(String domainPath) {
        this.domainPath = domainPath;
    }

    public String getDomainValue() {
        return domainValue;
    }

    public void setDomainValue(String domainValue) {
        this.domainValue = domainValue;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }
}
