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

    public String getMoTa() {
        return this.moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
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



    @Override
    public String toString() {
        return "{" +
            " maPB='" + getMaPB() + "'" +
            ", tenPB='" + getTenPB() + "'" +
            ", moTa='" + getMoTa() + "'" +
            ", trangThaiPB='" + isTrangThaiPB() + "'" +
            "}";
    }
}
