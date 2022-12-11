package com.example.demo.service;

import java.util.List;

import com.example.demo.model.ChucVu;

public interface ChucVuService {
    ChucVu findBymaCV(Long maCV); 
    Boolean existsBytenCV(String tenCV);
    ChucVu save(ChucVu chucVu);
    List<ChucVu> findAllChucVu();
    public boolean deleteById(int id) ;
    public ChucVu updateChucVu(ChucVu cV,Long id) ;
    ChucVu findBytencV(String maCV); 
}
