package com.example.demo.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.ChucVu;
import com.example.demo.repository.NhanVienRepository;
import com.example.demo.repository.ChucVuRepository;
import com.example.demo.service.ChucVuService;

@Service
public class ChucVuServiceImpl implements ChucVuService {

    @Autowired
    ChucVuRepository chucVuRepository;
    @Autowired
    NhanVienRepository nhanVienRepository;

    @Override
    public ChucVu findBymaCV(Long maCV) {
        return chucVuRepository.findBymaCV(maCV);
    }

    @Override
    public ChucVu findBytencV(String maCV) {
        return chucVuRepository.findBytenCV(maCV);
    }

    @Override
    public ChucVu save(ChucVu ChucVu) {
        return chucVuRepository.save(ChucVu);
    }

    @Override
    public List<ChucVu> findAllChucVu() {
        List<ChucVu> ChucVus = chucVuRepository.findAll();
        return ChucVus;
    }

    @Override
    public boolean deleteById(int id) {
        try {
            //ChucVuRepository.deleteById((long) id); 
            ChucVu chucVu = chucVuRepository.findBymaCV(Long.valueOf(id));
          
            chucVu.setTrangThaiCV(false);
            chucVuRepository.save(chucVu);
            return true;
        } catch (Exception e) {
            System.out.println("Xóa thất bại");
            return false;
        }
    }

    @Override
    public ChucVu updateChucVu(ChucVu CV, Long id) {
        ChucVu ChucVu = chucVuRepository.findBymaCV(id);
		ChucVu.setTenCV(CV.getTenCV());
        ChucVu.setMoTaCV(CV.getMoTaCV());
        return chucVuRepository.save(ChucVu);   
    }

    @Override
    public Boolean existsBytenCV(String tenCV) {
        return chucVuRepository.existsBytenCV(tenCV);
    }

    
}
