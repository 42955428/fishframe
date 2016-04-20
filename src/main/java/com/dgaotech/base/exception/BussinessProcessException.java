
package com.dgaotech.base.exception;

/**
 * 异常类
 * @author fujin
 * 
 *
 */
public class BussinessProcessException extends RuntimeException {
	public BussinessProcessException() {
		super();
	}

	public BussinessProcessException(String message) {
		super(message);
	}

	public BussinessProcessException(String message, Throwable cause) {
		super(message, cause);
	}

	public BussinessProcessException(Throwable cause) {
		super(cause);
	}
}
