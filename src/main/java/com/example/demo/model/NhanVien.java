package com.example.demo.model;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;



@Entity
@Table(name = "NhanVien", uniqueConstraints = { // uniqueConstraints unique in database
                @UniqueConstraint(columnNames = {
                                "maNV"
                }),
                @UniqueConstraint(columnNames = {
                                "cCCD"
                }),
                @UniqueConstraint(columnNames = {
                                "email"
                })
})
public class NhanVien {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long maNV;
        @NotBlank (message = "User's tenNhanSu cannot be empty.")
        @Size(min = 3, max = 50)
        private String tenNhanSu;
        @NotBlank(message = "User's cccd cannot be empty.")
        @Size(min = 9, max = 13)
        private String cCCD;
        // @NaturalId
        @NotBlank(message = "User's  email cannot be empty.")
        @Size(max = 100)
        @Email
        private String email;
        // @JsonIgnore Mã hóa
        @NotBlank(message = "User's  ngaySinh cannot be empty.")
        @Size(min = 6, max = 100)
        private String ngaySinh;
        @Lob
        private String hinhAnh;
        @NotBlank(message = "User's cannot be empty.")
        @Size(max = 50)
        private String danToc;
        @NotBlank(message = "User's info cannot be empty.")
        @Size(max = 50)
        private String quocTich;
        @NotBlank(message = "User's info cannot be empty.")
        @Size(max = 50)
        private String ngayKyHopDong;
        @NotBlank(message = "User's info cannot be empty.")
        @Size(max = 50)
        private String soTK;
        @NotBlank(message = "User's info cannot be empty.")
        @Size(max = 50)
        private String sDT;
        @Lob
        private String qrCode;
        private Boolean trangThai=true;
        private Boolean gioiTinh=true;


        public NhanVien( String tenNhanSu, String cCCD, String email, String ngaySinh, String hinhAnh, String danToc, String quocTich, String ngayKyHopDong, String soTK, String sDT,boolean gioiTich) {
                this.tenNhanSu = tenNhanSu;
                this.cCCD = cCCD;
                this.email = email;
                this.ngaySinh = ngaySinh;
                this.hinhAnh = hinhAnh;
                this.danToc = danToc;
                this.quocTich = quocTich;
                this.ngayKyHopDong = ngayKyHopDong;
                this.soTK = soTK;
                this.sDT = sDT;
                this.gioiTinh=gioiTinh;
        }
        
       /*  public NhanVien(String tenNhanSu, String cCCD, String email, String ngaySinh, String hinhAnh,
                        String danToc, String quocTich, String ngayKyHopDong, String soTK) {
                this.tenNhanSu = tenNhanSu;
                this.cCCD = cCCD;
                this.email = email;
                this.ngaySinh = ngaySinh;
                this.hinhAnh = hinhAnh;
                this.danToc = danToc;
                this.quocTich = quocTich;
                this.ngayKyHopDong = ngayKyHopDong;
                this.soTK = soTK;
        }
 */
        public NhanVien() {
        }

        public Long getMaNV() {
                return this.maNV;
        }

        public void setMaNV(Long maNV) {
                this.maNV = maNV;
        }

        public String getTenNhanSu() {
                return this.tenNhanSu;
        }

        public void setTenNhanSu(String tenNhanSu) {
                this.tenNhanSu = tenNhanSu;
        }

        public String getCCCD() {
                return this.cCCD;
        }

        public void setCCCD(String cCCD) {
                this.cCCD = cCCD;
        }

        public String getEmail() {
                return this.email;
        }

        public void setEmail(String email) {
                this.email = email;
        }

        public String getNgaySinh() {
                return this.ngaySinh;
        }

        public void setNgaySinh(String ngaySinh) {
                this.ngaySinh = ngaySinh;
        }

        public String getHinhAnh() {
                return this.hinhAnh;
        }

        public void setHinhAnh(String hinhAnh) {
                this.hinhAnh = hinhAnh;
        }

        public String getDanToc() {
                return this.danToc;
        }

        public void setDanToc(String danToc) {
                this.danToc = danToc;
        }

        public String getQuocTich() {
                return this.quocTich;
        }

        public void setQuocTich(String quocTich) {
                this.quocTich = quocTich;
        }

        public String getNgayKyHopDong() {
                return this.ngayKyHopDong;
        }

        public void setNgayKyHopDong(String ngayKyHopDong) {
                this.ngayKyHopDong = ngayKyHopDong;
        }

        public String getSoTK() {
                return this.soTK;
        }

        public void setSoTK(String soTK) {
                this.soTK = soTK;
        }

        public String getSDT() {
                return this.sDT;
        }

        public void setSDT(String sDT) {
                this.sDT = sDT;
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

        public String getQrCode() {
                return this.qrCode;
        }

        public void setQrCode(String qrCode) {
                this.qrCode = qrCode;
        }

        public Boolean isGioiTinh() {
                return this.gioiTinh;
        }

        public Boolean getGioiTinh() {
                return this.gioiTinh;
        }

        public void setGioiTinh(Boolean gioiTinh) {
                this.gioiTinh = gioiTinh;
        }
       

        @Override
        public String toString() {
                return "{" +
                        ", tenNhanSu='" + getTenNhanSu() + "'" +
                        ", cCCD='" + getCCCD() + "'" +
                        ", email='" + getEmail() + "'" +
                        ", ngaySinh='" + getNgaySinh() + "'" +
                        ", danToc='" + getDanToc() + "'" +
                        ", quocTich='" + getQuocTich() + "'" +
                        ", ngayKyHopDong='" + getNgayKyHopDong() + "'" +
                        ", soTK='" + getSoTK() + "'" +
                        ", sDT='" + getSDT() + "'" +
                        ", qrCode='" + getQrCode() + "'" +
                        ", trangThai='" + isTrangThai() + "'" +
                        "}";
        }


   

}
