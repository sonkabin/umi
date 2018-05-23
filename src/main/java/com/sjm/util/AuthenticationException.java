package com.sjm.util;

public class AuthenticationException extends RuntimeException {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1178098129544831899L;

	public AuthenticationException(){
        super();
    }

    public AuthenticationException(String s){
        super(s);
    }
}
