package com.cronos.customer.exception;

import java.io.Serializable;

public class CronosException extends RuntimeException implements Serializable {

    private final String errorCode;
    private transient Object[] arguments;

    public CronosException() {
        super();
        this.errorCode = null;
        this.arguments = null;
    }


    public CronosException(String errorCode) {
        super(errorCode);
        this.errorCode = errorCode;
        this.arguments = null;
    }





}
