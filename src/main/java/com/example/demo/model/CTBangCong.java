package com.example.demo.model;

import java.sql.Time;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "ctBangCong")
public class CTBangCong {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long maBC;
    
    private Date ngay;
    private Time gioVao;
    private Time gioRa;
    @NotBlank
    private String maLoaiCong;
    

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "bangcong",
    joinColumns = @JoinColumn(name = "ctbangcong_id"),inverseJoinColumns = @JoinColumn(name = "nhanvien_id"))
    Set<NhanVien> nv = new HashSet<>();

    public CTBangCong() {
    }

    public CTBangCong(Date ngay, Time gioVao, Time gioRa, String maLoaiCong, Boolean trangThaiBC) {
        this.ngay = ngay;
        this.gioVao = gioVao;
        this.gioRa = gioRa;
        this.maLoaiCong = maLoaiCong;
    }
    public CTBangCong(Date ngay, Time gioVao, Time gioRa, String maLoaiCong, Boolean trangThaiBC,Set<NhanVien> nv) {
        this.ngay = ngay;
        this.gioVao = gioVao;
        this.gioRa = gioRa;
        this.maLoaiCong = maLoaiCong;
        this.nv=nv;
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


    public Set<NhanVien> getNv() {
        return this.nv;
    }

    public void setNv(Set<NhanVien> nv) {
        this.nv = nv;
    }

}
