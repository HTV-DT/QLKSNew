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
    @org.springframework.data.annotation.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long maSoLuong;
    @NotBlank // Not null
    @Size(min = 0, max = 50)
    private Double LuongCoBan;
    private int soGioLam;
    private Date ngay;

    @ManyToOne 
    @JoinColumn(name = "nhanvien_id")
    private NhanVien nhanVien;

    public Luong() {

    }

    public Luong(Long maSoLuong, Double LuongCoBan, int soGioLam, NhanVien nhanVien) {
        this.maSoLuong = maSoLuong;
        this.LuongCoBan = LuongCoBan;
        this.soGioLam = soGioLam;
        this.nhanVien = nhanVien;
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

    public int getSoGioLam() {
        return this.soGioLam;
    }

    public void setSoGioLam(int soGioLam) {
        this.soGioLam = soGioLam;
    }

    public NhanVien getNhanVien() {
        return this.nhanVien;
    }

    public void setNhanVien(NhanVien nhanVien) {
        this.nhanVien = nhanVien;
    }

}