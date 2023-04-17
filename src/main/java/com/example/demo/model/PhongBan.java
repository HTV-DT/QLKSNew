package com.example.demo.model;


import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.hibernate.annotations.Cascade;

@Entity
@Table(name = "PhongBan")
public class PhongBan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long maPB;
    @NotBlank // Not null
    @Size(min = 0, max = 50)
    private String tenPB;
    private String moTa;
    private boolean trangThaiPB=true;


    public String getMoTa() {
        return this.moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }



    @OneToMany(mappedBy = "phongBan", cascade = CascadeType.ALL) // Quan hệ 1-n với đối tượng ở dưới (nhanVien) (1 địa điểm có nhiều người ở)
    // MapopedBy trỏ tới tên biến phongBan ở trong nhanVien.
    @Cascade(value= {org.hibernate.annotations.CascadeType.SAVE_UPDATE})
    private Collection<NhanVien> nhanViens;


    public PhongBan(Long maPB, String tenPB, String moTa, boolean trangThaiPB) {
        this.maPB = maPB;
        this.tenPB = tenPB;
        this.moTa = moTa;
        this.trangThaiPB = trangThaiPB;
     
    }
    

    public PhongBan(String tenPB, String moTa) {
        this.tenPB = tenPB;
        this.moTa = moTa;
    }


    public PhongBan() {
    }


    public Long getMaPB() {
        return this.maPB;
    }

    public void setMaPB(Long maPB) {
        this.maPB = maPB;
    }

    public String getTenPB() {
        return this.tenPB;
    }

    public void setTenPB(String tenPB) {
        this.tenPB = tenPB;
    }

   
    @Override
    public String toString() {
        return "{" +
                " maPB='" + getMaPB() + "'" +
                ", tenPB='" + getTenPB() + "'" +
                "}";
    }
    public boolean isTrangThaiPB() {
        return this.trangThaiPB;
    }

    public boolean getTrangThaiPB() {
        return this.trangThaiPB;
    }

    public void setTrangThaiPB(boolean trangThaiPB) {
        this.trangThaiPB = trangThaiPB;
    }

}
