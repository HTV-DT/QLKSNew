
    package com.example.demo.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Phongs")
public class Phong {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Phong_id;
    @NotBlank
    @Size(max = 255)
    private String Phong_name;
    @NotBlank
    @Column(columnDefinition="TEXT")
    private String GhiChu;
    @NotBlank
    @Size(max = 100)
    private Double price;
    @NotBlank
    @Lob
    private String image_url;



    @ManyToOne
     @JoinColumn(name="loaiphong_id", nullable=false) //ctegory_id chính là trường khoá phụ trong table Phong liên kết với khóa chính trong table loaiphong
     private LoaiPhong loaiphong;
    
    public Phong() {
    }

    public Phong(Long Phong_id, String Phong_name, String GhiChu, Double price, String image_url,LoaiPhong loaiphong) {
        this.Phong_id = Phong_id;
        this.Phong_name = Phong_name;
        this.GhiChu = GhiChu;
        this.price = price;
        this.image_url = image_url;
        this.loaiphong=loaiphong;
    }

  

    public Long getPhong_id() {
        return this.Phong_id;
    }

    public void setPhong_id(Long Phong_id) {
        this.Phong_id = Phong_id;
    }

    public String getPhong_name() {
        return this.Phong_name;
    }

    public void setPhong_name(String Phong_name) {
        this.Phong_name = Phong_name;
    }

    public String getGhiChu() {
        return this.GhiChu;
    }

    public void setGhiChu(String GhiChu) {
        this.GhiChu = GhiChu;
    }

    public Double getPrice() {
        return this.price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getImage_url() {
        return this.image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }

    public LoaiPhong getLoaiphong() {
        return this.loaiphong;
    }

    public void setLoaiphong(LoaiPhong loaiphong) {
        this.loaiphong = loaiphong;
    }
  
}


