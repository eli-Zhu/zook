package com.zook.persistence.dataobject;


import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.io.*;
import java.util.*;

/**
 * table:ZOOK_RESOURCE
 * @author eli
 * */
public class ZookResourceDO implements Serializable {
	private static final long serialVersionUID = -5216457518046898601L;
	
	/**
	 * 主键 		db_column: id 
	 */
	private long id;
	/**
	 * 域名Id 		db_column: domain_id 
	 */
	private long domainId;
	/**
	 * 资源名称 		db_column: resource_name 
	 */
	private String resourceName;
	/**
	 * 资源路径 		db_column: resource_path 
	 */
	private String resourcePath;
	/**
	 * 资源路径值（ZK节点值） 		db_column: resource_value 
	 */
	private String resourceValue;
	/**
	 * 是否有效1:有效 0:无效 		db_column: is_valid 
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
	
	public void setDomainId(long domainId) {
		this.domainId = domainId;
	}
	
	public long getDomainId() {
		return this.domainId;
	}
	
	public void setResourceName(String resourceName) {
		this.resourceName = resourceName;
	}
	
	public String getResourceName() {
		return this.resourceName;
	}
	
	public void setResourcePath(String resourcePath) {
		this.resourcePath = resourcePath;
	}
	
	public String getResourcePath() {
		return this.resourcePath;
	}
	
	public void setResourceValue(String resourceValue) {
		this.resourceValue = resourceValue;
	}
	
	public String getResourceValue() {
		return this.resourceValue;
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

