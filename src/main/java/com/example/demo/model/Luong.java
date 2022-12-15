package com.example.demo.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name = "luong")
public class Luong{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long maSoLuong;
    @NotBlank // Not null
    @Size(min = 0, max = 50)
    private Double LuongCoBan;
    private Double soGioLam;
    private Date ngay;


    public Luong() {

    }

    public Luong( Double LuongCoBan, Double soGioLam, Date ngay) {
        this.LuongCoBan = LuongCoBan;
        this.soGioLam = soGioLam;
        this.ngay = ngay;
       
    }

    public Long getMaSoLuong() {
        return this.maSoLuong;
    }

    public void setMaSoLuong(Long maSoLuong) {
        this.maSoLuong = maSoLuong;
    }

    public Double getLuongCoBan() {
        return this.LuongCoBan;
    }

    public void setLuongCoBan(Double LuongCoBan) {
        this.LuongCoBan = LuongCoBan;
    }

    public Double getSoGioLam() {
        return this.soGioLam;
    }

    public void setSoGioLam(Double soGioLam) {
        this.soGioLam = soGioLam;
    }

    public Date getNgay() {
        return this.ngay;
    }

    public void setNgay(Date ngay) {
        this.ngay = ngay;
    }

  

}