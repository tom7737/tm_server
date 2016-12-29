
package com.bjgt.ms.util;


public class AppException extends Exception {
	private static final long serialVersionUID = -7740350763992926666L;
	
	// 异常错误代码
    private int errorCode = Constants.CODE_OK;
    // 异常原因
    protected Throwable cause;
    
    public AppException(int errorCode) {
        super();
        this.errorCode = errorCode;
    }
    
    public AppException(String message, int errorCode) {
        super(message);
        this.errorCode = errorCode;
    }
    
    public AppException(Throwable cause, int errorCode) {
        super(cause);
        this.cause = cause;
        this.errorCode = errorCode;
    }
    
    public AppException(String message, Throwable cause, int errorCode) {
        super(message, cause);
        this.errorCode = errorCode;
        this.cause = cause;
    }
    
    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }
    
    public static String getStackMsg(final Exception e) {
        StringBuffer sb = new StringBuffer();
        StackTraceElement stackArray[] = e.getStackTrace();

        for (int i = 0; i < stackArray.length; i++) {
            StackTraceElement element = stackArray[i];
            sb.append(element.toString() + "\n");
        }

        return sb.toString();
    }
    
}
