package com.example.demo.model;

import java.util.Date;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;



@Entity
@Table(name = "KhachHang", uniqueConstraints = { // uniqueConstraints unique in database
                @UniqueConstraint(columnNames = {
                                "MaKhachHang"
                })
             
})
public class KhachHang {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long MaKhachHang;
        @NotBlank (message = "User's tenNhanSu cannot be empty.")
        @Size(min = 3, max = 50)
        private String TenKhachHang;
        @NotBlank(message = "User's cccd cannot be empty.")
        @Size(min = 12, max = 12)
        private Integer CCCD;
        // @NaturalId
        @NotBlank(message = "User's  email cannot be empty.")
        private Boolean GioiTinh;
        // @JsonIgnore Mã hóa
        @NotBlank(message = "User's  ngaySinh cannot be empty.")
        @Size(min = 6, max = 100)
        private String DiaChi;
        @NotBlank(message = "User's info cannot be empty.")
        @Size(max = 50)
        private String QuocTich;
        @NotBlank(message = "User's cannot be empty.")
        @JsonFormat(pattern="dd-MM-yyyy")
        private Date NgaySinh;
        @NotBlank(message = "User's info cannot be empty.")
        @Size(max = 10)
        private String SDT;
        @NotBlank(message = "User's info cannot be empty.")
        @Size(max = 50)
        @Email
        private String Email;
        private Boolean trangThai=true;

    public KhachHang() {
    }


    public KhachHang(Long MaKhachHang, String TenKhachHang, Integer CCCD, Boolean GioiTinh, String DiaChi, String QuocTich, Date NgaySinh, String SDT, String Email, Boolean trangThai) {
        this.MaKhachHang = MaKhachHang;
        this.TenKhachHang = TenKhachHang;
        this.CCCD = CCCD;
        this.GioiTinh = GioiTinh;
        this.DiaChi = DiaChi;
        this.QuocTich = QuocTich;
        this.NgaySinh = NgaySinh;
        this.SDT = SDT;
        this.Email = Email;
        this.trangThai = trangThai;
    }
     


    public Long getMaKhachHang() {
        return this.MaKhachHang;
    }

    public void setMaKhachHang(Long MaKhachHang) {
        this.MaKhachHang = MaKhachHang;
    }

    public String getTenKhachHang() {
        return this.TenKhachHang;
    }

    public void setTenKhachHang(String TenKhachHang) {
        this.TenKhachHang = TenKhachHang;
    }

    public Integer getCCCD() {
        return this.CCCD;
    }

    public void setCCCD(Integer CCCD) {
        this.CCCD = CCCD;
    }

    public Boolean isGioiTinh() {
        return this.GioiTinh;
    }

    public Boolean getGioiTinh() {
        return this.GioiTinh;
    }

    public void setGioiTinh(Boolean GioiTinh) {
        this.GioiTinh = GioiTinh;
    }

    public String getDiaChi() {
        return this.DiaChi;
    }

    public void setDiaChi(String DiaChi) {
        this.DiaChi = DiaChi;
    }

    public String getQuocTich() {
        return this.QuocTich;
    }

    public void setQuocTich(String QuocTich) {
        this.QuocTich = QuocTich;
    }

    public Date getNgaySinh() {
        return this.NgaySinh;
    }

    public void setNgaySinh(Date NgaySinh) {
        this.NgaySinh = NgaySinh;
    }

    public String getSDT() {
        return this.SDT;
    }

    public void setSDT(String SDT) {
        this.SDT = SDT;
    }

    public String getEmail() {
        return this.Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public Boolean isTrangThai() {
        return this.trangThai;
    }

    public Boolean getTrangThai() {
        return this.trangThai;
    }

    public void setTrangThai(Boolean trangThai) {
        this.trangThai = trangThai;
    }
   

}
