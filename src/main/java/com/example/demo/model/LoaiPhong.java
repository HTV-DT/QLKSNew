
package com.example.demo.model;

import java.util.Set;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;


@Entity
@Table(name = "LoaiPhong")
public class LoaiPhong {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long MaLoaiPhong;
    @NotBlank
    @Size(max = 255)
    private String TenLoaiPhong;

    public LoaiPhong() {
    }

    public LoaiPhong(Long  MaLoaiPhong, String TenLoaiPhong) {
        this. MaLoaiPhong =  MaLoaiPhong;
        this.TenLoaiPhong = TenLoaiPhong;
    }


    public Long getMaLoaiPhong() {
        return this.MaLoaiPhong;
    }

    public void setMaLoaiPhong(Long MaLoaiPhong) {
        this.MaLoaiPhong = MaLoaiPhong;
    }

    public String getTenLoaiPhong() {
        return this.TenLoaiPhong;
    }

    public void setTenLoaiPhong(String TenLoaiPhong) {
        this.TenLoaiPhong = TenLoaiPhong;
    }

 

}