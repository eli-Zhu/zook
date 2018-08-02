package com.zook.core.vo;

/**
 * 资源路径模型
 * Created by Eli on 2018/8/2.
 */
public class ResourceVO extends ZookBaseVO{

    /**  */
    private static final long serialVersionUID = -284582032297519193L;
    /**主键*/
    private Long              id;
    /**域名Id*/
    private Long              domainId;
    /**资源名称描述*/
    private String            resourceName;
    /**资源路径*/
    private String            resourcePath;
    /**资源路径值（ZK节点值）*/
    private String            resourceValue;
    /** 操作人 */
    private String            operator;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getDomainId() {
        return domainId;
    }

    public void setDomainId(Long domainId) {
        this.domainId = domainId;
    }

    public String getResourceName() {
        return resourceName;
    }

    public void setResourceName(String resourceName) {
        this.resourceName = resourceName;
    }

    public String getResourcePath() {
        return resourcePath;
    }

    public void setResourcePath(String resourcePath) {
        this.resourcePath = resourcePath;
    }

    public String getResourceValue() {
        return resourceValue;
    }

    public void setResourceValue(String resourceValue) {
        this.resourceValue = resourceValue;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }
}
