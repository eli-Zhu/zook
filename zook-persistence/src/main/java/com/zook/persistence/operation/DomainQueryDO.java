package com.zook.persistence.operation;

/**
 * 域查询
 * Created by Eli on 2018/8/15.
 */
public class DomainQueryDO {
    private static final long serialVersionUID = -5216450118046198601L;
    /** 域名描述 */
    private String domainName;
    /** 域名路径 */
    private String domainPath;

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
}
