package com.app.exception;

import com.sqds.exception.SqdsException;

/**
 * 用户未登录exception
 * 
 * @author ccj
 * 
 */
@SuppressWarnings("serial")
public class UserNoLogonException extends SqdsException {

	public UserNoLogonException() {
		super();
	}

	public UserNoLogonException(String exception) {
		super(exception);
	}
}
