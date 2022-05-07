package com.mms.common.system.data;

import org.springframework.jdbc.support.JdbcUtils;

import java.util.HashMap;

public class CamelDataHashMap extends HashMap {
    private static final long serialVersionUID = 362498820763181265L;

    @SuppressWarnings("unchecked")
    @Override
    public Object put(Object key, Object value){
        return super.put(JdbcUtils.convertUnderscoreNameToPropertyName((String) key), value );
    }

    public String getStringNvl(Object key){
        Object objValue = super.get(key);
        if ( objValue instanceof String && objValue != null && !"NULL".equals( ((String) objValue).toUpperCase() ) ){
            return objValue.toString();
        }else{
            return "";
        }
    }
}
