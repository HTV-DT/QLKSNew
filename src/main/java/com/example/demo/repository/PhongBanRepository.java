package com.example.demo.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.model.PhongBan;

@Repository
public interface PhongBanRepository extends JpaRepository<PhongBan, Long>{
   PhongBan findBymaPB(Long maPB); //Tim kiem User co ton tai trong DB khong?
   Boolean existsBytenPB(String tenPB);
   PhongBan findBytenPB(String maPB); 
   @Query(value = "SELECT * FROM phong_ban pb WHERE pb.trang_thaipb=1", nativeQuery=true)
   List<PhongBan> ListAll();
}
