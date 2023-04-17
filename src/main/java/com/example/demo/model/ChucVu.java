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
@Table(name = "chucvu")
public class ChucVu{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long maCV;
    @NotBlank // Not null
    @Size(min = 0, max = 50)
    private String tenCV;
    private String moTaCV;
    private boolean trangThaiCV=true;



    public ChucVu() {
    }

    public ChucVu(String tenCV, String moTaCV) {
        this.tenCV = tenCV;
        this.moTaCV = moTaCV;
    }

    public Long getMaCV() {
        return this.maCV;
    }

    public void setMaCV(Long maCV) {
        this.maCV = maCV;
    }

    public String getTenCV() {
        return this.tenCV;
    }

    public void setTenCV(String tenCV) {
        this.tenCV = tenCV;
    }

    public String getMoTaCV() {
        return this.moTaCV;
    }

    public void setMoTaCV(String moTaCV) {
        this.moTaCV = moTaCV;
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



    @Override
    public String toString() {
        return "{" +
            " maCV='" + getMaCV() + "'" +
            ", tenCV='" + getTenCV() + "'" +
            ", moTaCV='" + getMoTaCV() + "'" +
            "}";
    }


}