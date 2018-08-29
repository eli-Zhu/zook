package com.zook.persistence.operation;

import java.io.Serializable;

/**
 * Created by Eli on 2018/8/15.
 */
public class BaseQO implements Serializable{
    private static final long serialVersionUID = -5216457518046898601L;
    /**页码*/
    private Integer page;
    /**条数*/
    private Integer rows;

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getRows() {
        return rows;
    }

    public void setRows(Integer rows) {
        this.rows = rows;
    }
}
