package com.example.demo.dto.request;

public class AddPhongBanForm {
    private String tenPB;
    private String moTa;


    public AddPhongBanForm() {
    }


    public AddPhongBanForm(String tenPB, String moTa) {
        this.tenPB = tenPB;
        this.moTa = moTa;
    }

    public String getTenPB() {
        return this.tenPB;
    }

    public void setTenPB(String tenPB) {
        this.tenPB = tenPB;
    }

    public String getMoTa() {
        return this.moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }
   
}
