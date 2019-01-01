package com.wisilica.wiseconnect.util.type;


public enum ErrorCode {    
       
    UN_EXPECTED_ERROR("UN_EXPECTED_ERROR", "Un expected error"),        
    UN_AUTHORIZED_ACCESS("UN_AUTHORIZED_ACCESS", "Un authorized access");
    
    private final String code;

    private final String description;

    private ErrorCode(String code, String description) {
        this.code = code;
        this.description = description;
    }

    public String getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }
}
