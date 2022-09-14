package com.exercise2.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class PaymentException extends Exception {
	
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		
		private final Logger logger = LoggerFactory.getLogger(this.getClass());
		
	    private int code;
	    private String message;

	    public PaymentException(int code, String message) {
	        super(message);
	        this.code = code;
	        this.message = message;
	        logger.error(message, this);
	    }

		public int getCode() {
			return code;
		}

		public void setCode(int code) {
			this.code = code;
		}

		public String getMessage() {
			return message;
		}

		public void setMessage(String message) {
			this.message = message;
		}
}
