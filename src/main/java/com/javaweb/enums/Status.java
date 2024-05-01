package com.javaweb.enums;

import java.util.LinkedHashMap;
import java.util.Map;

public enum Status {

    DANG_XL("Đang xử lý"),

    DA_XL("Đã xử lý"),

    CHUA_XL("Chưa xử lý");

    private final String statusName;

    Status(String statusName){
        this.statusName= statusName;
    }

    public static Map<String,String>statusType(){
        Map<String,String>statuss = new LinkedHashMap<>();
        for(Status it:Status.values()){
            statuss.put(it.toString(),it.statusName);
        }
        return statuss;
    }

}
