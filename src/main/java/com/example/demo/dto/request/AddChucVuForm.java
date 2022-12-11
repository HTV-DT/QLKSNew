package com.example.demo.dto.request;

public class AddChucVuForm {
    private String tenCV;
    private String moTaCV;


    public AddChucVuForm() {
    }


    public AddChucVuForm(String tenCV, String moTaCV) {
        this.tenCV = tenCV;
        this.moTaCV = moTaCV;
    }

    public String getTenCV() {
        return this.tenCV;
    }

    public void setTenCV(String tenCV) {
        this.tenCV = tenCV;
    }

    public String getMoTaCV() {
        return this.moTaCV;
    }

    public void setMoTaCV(String moTaCV) {
        this.moTaCV = moTaCV;
    }
   
}
