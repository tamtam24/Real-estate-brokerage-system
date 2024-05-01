package com.javaweb.enums;

import java.util.LinkedHashMap;
import java.util.Map;

public enum InstallmentStatus {

    CHUA("Chưa tới hạn"),

    DA("Đã tới hạn"),

    QUA("Quá hạn");

    private final String statusInstallment;

    InstallmentStatus(String statusInstallment){
        this.statusInstallment= statusInstallment;
    }

    public static Map<String,String> statusInstallmentType(){
        Map<String,String>statuss = new LinkedHashMap<>();
        for(InstallmentStatus it:InstallmentStatus.values()){
            statuss.put(it.toString(),it.statusInstallment);
        }
        return statuss;
    }
}
