package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.BangCong;

@Repository
public interface BangCongRepository extends JpaRepository<BangCong, Long>{
  
}
