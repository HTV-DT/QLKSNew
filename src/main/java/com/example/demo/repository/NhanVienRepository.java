package com.example.demo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.model.NhanVien;
import com.example.demo.model.PhongBan;

@Repository
public interface NhanVienRepository extends JpaRepository<NhanVien, Long>{
    Optional<NhanVien> findBycCCD(String cCCD); //Tim kiem User co ton tai trong DB khong?
    Boolean existsByEmail(String email); //email da co trong DB chua
    NhanVien findBymaNV(Long maNV);
    Boolean existsByPhongBan(PhongBan phongBan);
    @Query(value = "SELECT * FROM nhan_vien nv WHERE CONCAT(nv.manv, ' ',nv.ten_nhan_su) LIKE %?1%", nativeQuery=true)
    List<NhanVien> search(String keyword);
}   
