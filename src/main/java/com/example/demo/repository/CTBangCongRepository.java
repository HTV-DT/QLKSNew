package com.example.demo.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.CTBangCong;

@Repository
public interface CTBangCongRepository extends JpaRepository<CTBangCong, Long>{    
  
}
