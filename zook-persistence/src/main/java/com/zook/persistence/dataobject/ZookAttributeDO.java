/**
 * LY.com Inc.
 * Copyright (c) 2004-2016 All Rights Reserved.
 */
package com.zook.persistence.dataobject;


import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.io.*;
import java.util.*;

/**
 * table:ZOOK_ATTRIBUTE
 * @author eli
 * */
public class ZookAttributeDO implements Serializable {
	private static final long serialVersionUID = -5216457518046898601L;
	
	/**
	 * 主键 		db_column: id 
	 */
	private long id;
	/**
	 * 资源Id 		db_column: resource_id 
	 */
	private long resourceId;
	/**
	 * 属性描述 		db_column: attribute_name 
	 */
	private String attributeName;
	/**
	 * 属性路径 		db_column: attribute_path 
	 */
	private String attributePath;
	/**
	 * 属性值 		db_column: attribute_value 
	 */
	private String attributeValue;
	/**
	 * 是否有效 1:有效 		db_column: is_valid 
	 */
	private String isValid;
	/**
	 * 备注 		db_column: remark 
	 */
	private String remark;
	/**
	 * 创建时间 		db_column: create_time 
	 */
	private Date createTime;
	/**
	 * 更新时间 		db_column: update_time 
	 */
	private Date updateTime;
	/**
	 * 操作人 		db_column: operator 
	 */
	private String operator;

	
	public void setId(long id) {
		this.id = id;
	}
	
	public long getId() {
		return this.id;
	}
	
	public void setResourceId(long resourceId) {
		this.resourceId = resourceId;
	}
	
	public long getResourceId() {
		return this.resourceId;
	}
	
	public void setAttributeName(String attributeName) {
		this.attributeName = attributeName;
	}
	
	public String getAttributeName() {
		return this.attributeName;
	}
	
	public void setAttributePath(String attributePath) {
		this.attributePath = attributePath;
	}
	
	public String getAttributePath() {
		return this.attributePath;
	}
	
	public void setAttributeValue(String attributeValue) {
		this.attributeValue = attributeValue;
	}
	
	public String getAttributeValue() {
		return this.attributeValue;
	}
	
	public void setIsValid(String isValid) {
		this.isValid = isValid;
	}
	
	public String getIsValid() {
		return this.isValid;
	}
	
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	public String getRemark() {
		return this.remark;
	}
	
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	
	public Date getCreateTime() {
		return this.createTime;
	}
	
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	
	public Date getUpdateTime() {
		return this.updateTime;
	}
	
	public void setOperator(String operator) {
		this.operator = operator;
	}
	
	public String getOperator() {
		return this.operator;
	}
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
	}

}

