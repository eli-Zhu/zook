package com.zook.core.vo;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Eli on 2018/8/2.
 */
public class ZookBaseVO implements Serializable{
    /**  */
    private static final long serialVersionUID = -173517169423263174L;

    /**备注*/
    private String  remark;
    /**是否有效 1:有效 0:无效*/
    private String  isValid;
    /**创建时间*/
    private Date    createTime;
    /**更新时间*/
    private Date    updateTime;

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getIsValid() {
        return isValid;
    }

    public void setIsValid(String isValid) {
        this.isValid = isValid;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}
