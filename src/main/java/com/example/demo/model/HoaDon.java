
package com.example.demo.model;

import java.util.Collection;
import java.util.Date;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.hibernate.annotations.Cascade;

@Entity
@Table(name = "HoaDon" ,uniqueConstraints = { // uniqueConstraints unique in database
    @UniqueConstraint(columnNames = {
                    "MaDatPhong"
    }),
    @UniqueConstraint(columnNames = {
                    "MaKhachHang"
    }),
    @UniqueConstraint(columnNames = {
                    "MaNhanVien"
    })
})
public class HoaDon{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long MaHoaDon;
    @NotBlank // Not null
    @Size(min = 0, max = 50)
    private Long MaNhanVien;
    private Long MaKhachHang;
    private Long MaDatPhong;
    private Date NgayLap;
    private Double ThanhTien;

    private boolean trangThaiCV=true;


    public HoaDon(Long MaHoaDon, Long MaNhanVien, Long MaKhachHang, Long MaDatPhong, Date NgayLap, Double ThanhTien, boolean trangThaiCV) {
        this.MaHoaDon = MaHoaDon;
        this.MaNhanVien = MaNhanVien;
        this.MaKhachHang = MaKhachHang;
        this.MaDatPhong = MaDatPhong;
        this.NgayLap = NgayLap;
        this.ThanhTien = ThanhTien;
        this.trangThaiCV = trangThaiCV;
    }

    public HoaDon() {
    }

    public Long getMaHoaDon() {
        return this.MaHoaDon;
    }

    public void setMaHoaDon(Long MaHoaDon) {
        this.MaHoaDon = MaHoaDon;
    }

    public Long getMaNhanVien() {
        return this.MaNhanVien;
    }

    public void setMaNhanVien(Long MaNhanVien) {
        this.MaNhanVien = MaNhanVien;
    }

    public Long getMaKhachHang() {
        return this.MaKhachHang;
    }

    public void setMaKhachHang(Long MaKhachHang) {
        this.MaKhachHang = MaKhachHang;
    }

    public Long getMaDatPhong() {
        return this.MaDatPhong;
    }

    public void setMaDatPhong(Long MaDatPhong) {
        this.MaDatPhong = MaDatPhong;
    }

    public Date getNgayLap() {
        return this.NgayLap;
    }

    public void setNgayLap(Date NgayLap) {
        this.NgayLap = NgayLap;
    }

    public Double getThanhTien() {
        return this.ThanhTien;
    }

    public void setThanhTien(Double ThanhTien) {
        this.ThanhTien = ThanhTien;
    }

    public boolean isTrangThaiCV() {
        return this.trangThaiCV;
    }

    public boolean getTrangThaiCV() {
        return this.trangThaiCV;
    }

    public void setTrangThaiCV(boolean trangThaiCV) {
        this.trangThaiCV = trangThaiCV;
    }

}