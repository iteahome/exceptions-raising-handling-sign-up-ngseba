package com.facebook.exception;

import com.facebook.exception.FbBusinessException;

public class FbUserAlreadyExistsException extends FbBusinessException {

    public FbUserAlreadyExistsException(){
    }

    public FbUserAlreadyExistsException(String message, Throwable cause) {super(message, cause);}
}
