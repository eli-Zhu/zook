/*
 * LY.com Inc.
 * Copyright (c) 2004-2016 All Rights Reserved.
 */
package com.zook.web.form;

import java.io.Serializable;


/**
 * The type Result msg.
 *
 * @author Eli
 * @version $Id : BaseForm.java, v 0.1 2016/4/14 21:02 hzy24985 Exp $
 */
public class ResultMsg implements Serializable{

    /**
     * The constant serialVersionUID.
     */
    private static final long serialVersionUID = -8185452078060722380L;

    /**
     * Instantiates a new Result msg.
     */
    public ResultMsg() {
    }

    /**
     * Instantiates a new Result msg.
     *
     * @param result  the result
     * @param message the message
     */
    public ResultMsg(boolean result, String message,Object obj) {
        this.result = result;
        this.message = message;
        this.obj = obj;
    }
    
    
    public static ResultMsg   success(){
       return  new ResultMsg(true,"sucess",null);
    }
    public static ResultMsg fail(){
        return  new ResultMsg(false,"system error",null);
    }
    public static ResultMsg fail(String errorInfo){
        return  new ResultMsg(false,errorInfo,null);
    }
    

    /**
     * Instantiates a new Result msg.
     *
     * @param result  the result
     * @param message the message
     */
    public ResultMsg(boolean result, String message) {
        this(result,message,null);
    }
    
    

    /**
     * The Result.
     */
    private boolean result = true;

    /**
     * The Message.
     */
    private String message;

    /**
     * The error code.
     */
    private String errorCode;
    
    /**
     * data
     */
    
    private Object obj;

    /**
     * Is result boolean.
     *
     * @return the boolean
     */
    public boolean isResult() {
        return result;
    }

    /**
     * Sets result.
     *
     * @param result the result
     * @return the result
     */
    public ResultMsg setResult(boolean result) {
        this.result = result;
        return this;
    }
    

    public Object getObj() {
        return obj;
    }

    public void setObj(Object obj) {
        this.obj = obj;
    }

    /**
     * Gets message.
     *
     * @return the message
     */
    public String getMessage() {
        return message;
    }

    /**
     * Sets message.
     *
     * @param message the message
     * @return the message
     */
    public ResultMsg setMessage(String message) {
        this.message = message;
        return this;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public ResultMsg setErrorCode(String errorCode) {
        this.errorCode = errorCode;
        return this;
    }
}
