package com.example.demo.dto.request;

public class AddPhongBanForm {
    private String tenPB;
    private String moTaPB;


    public AddPhongBanForm() {
    }


    public AddPhongBanForm(String tenPB, String moTaPB) {
        this.tenPB = tenPB;
        this.moTaPB = moTaPB;
    }

    public String getTenPB() {
        return this.tenPB;
    }

    public void setTenPB(String tenPB) {
        this.tenPB = tenPB;
    }

    public String getMoTaPB() {
        return this.moTaPB;
    }

    public void setMoTaPB(String moTaPB) {
        this.moTaPB = moTaPB;
    }
   
}
