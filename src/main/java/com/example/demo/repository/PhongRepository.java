package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Phong;



@Repository
public interface PhongRepository extends JpaRepository<Phong, Long> {

}
