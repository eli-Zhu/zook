package com.zook.core.vo;

/**
 * 资源属性模型
 * Created by Eli on 2018/8/2.
 */
public class AttributeVO extends ZookBaseVO{
    /**  */
    private static final long serialVersionUID = -9041780159230398464L;
    /**主键*/
    private Long              id;
    /**资源Id*/
    private Long              resourceId;
    /**属性名称描述*/
    private String            attributeName;
    /**属性路径*/
    private String            attributePath;
    /**属性值*/
    private String            attributeValue;
    /**1：推送zk,0:jmx  暂时只支持1*/
    private String            isZkFlag         = "1";
    /**jmx 方式推送 需要ip*/
    private String            ipAddress;
    /** 操作人 */
    private String            operator;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getResourceId() {
        return resourceId;
    }

    public void setResourceId(Long resourceId) {
        this.resourceId = resourceId;
    }

    public String getAttributeName() {
        return attributeName;
    }

    public void setAttributeName(String attributeName) {
        this.attributeName = attributeName;
    }

    public String getAttributePath() {
        return attributePath;
    }

    public void setAttributePath(String attributePath) {
        this.attributePath = attributePath;
    }

    public String getAttributeValue() {
        return attributeValue;
    }

    public void setAttributeValue(String attributeValue) {
        this.attributeValue = attributeValue;
    }

    public String getIsZkFlag() {
        return isZkFlag;
    }

    public void setIsZkFlag(String isZkFlag) {
        this.isZkFlag = isZkFlag;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }
}
