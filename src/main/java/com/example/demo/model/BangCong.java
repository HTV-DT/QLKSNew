package com.example.demo.model;

import java.sql.Time;
import java.util.Date;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "BangCong")
public class BangCong {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long maBC;
    
    private Date ngay;
    private Time gioVao;
    private Time gioRa;

    @NotBlank
    private String maLoaiCong;
    private Boolean trangThaiBC=true;
    private Boolean trangThaiCCNV=true;

    

    @ManyToOne 
    @JoinColumn(name = "nhanvien_id") // thông qua khóa ngoại phongban_id
    private NhanVien nhanVien;
    

    public BangCong() {
    }

    public BangCong(Long maBC, Date ngay, Time gioVao, Time gioRa, String maLoaiCong, Boolean trangThaiBC, Boolean trangThaiCCNV, NhanVien nhanVien) {
        this.maBC = maBC;
        this.ngay = ngay;
        this.gioVao = gioVao;
        this.gioRa = gioRa;
        this.maLoaiCong = maLoaiCong;
        this.trangThaiBC = trangThaiBC;
        this.trangThaiCCNV = trangThaiCCNV;
        this.nhanVien = nhanVien;
    }

    public Long getMaBC() {
        return this.maBC;
    }

    public void setMaBC(Long maBC) {
        this.maBC = maBC;
    }

    public Date getNgay() {
        return this.ngay;
    }

    public void setNgay(Date ngay) {
        this.ngay = ngay;
    }

    public Time getGioVao() {
        return this.gioVao;
    }

    public void setGioVao(Time gioVao) {
        this.gioVao = gioVao;
    }

    public Time getGioRa() {
        return this.gioRa;
    }

    public void setGioRa(Time gioRa) {
        this.gioRa = gioRa;
    }

    public String getMaLoaiCong() {
        return this.maLoaiCong;
    }

    public void setMaLoaiCong(String maLoaiCong) {
        this.maLoaiCong = maLoaiCong;
    }

    public Boolean isTrangThaiBC() {
        return this.trangThaiBC;
    }

    public Boolean getTrangThaiBC() {
        return this.trangThaiBC;
    }

    public void setTrangThaiBC(Boolean trangThaiBC) {
        this.trangThaiBC = trangThaiBC;
    }

    public Boolean isTrangThaiCCNV() {
        return this.trangThaiCCNV;
    }

    public Boolean getTrangThaiCCNV() {
        return this.trangThaiCCNV;
    }

    public void setTrangThaiCCNV(Boolean trangThaiCCNV) {
        this.trangThaiCCNV = trangThaiCCNV;
    }

    public NhanVien getNhanVien() {
        return this.nhanVien;
    }

    public void setNhanVien(NhanVien nhanVien) {
        this.nhanVien = nhanVien;
    }


}
