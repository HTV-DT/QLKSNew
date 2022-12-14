package com.example.demo.repository;

import com.example.demo.model.Luong;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface LuongRepository extends JpaRepository<Luong, Long> {
    
}
