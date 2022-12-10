package com.example.demo.service.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.helper.BangCongImport;
import com.example.demo.model.BangCong;
import com.example.demo.model.NhanVien;
import com.example.demo.repository.BangCongRepository;
import com.example.demo.repository.NhanVienRepository;
import com.example.demo.service.BangCongService;

@Service
public class BangCongServiceImpl implements BangCongService{
    @Autowired
    BangCongRepository bangCongRepository;
    @Autowired //tự động truyền tải các mối quan hệ
    NhanVienRepository nhanVienRepository;

    @Override
    public void saveFile(MultipartFile file) {
        try {
            List<NhanVien> ds = nhanVienRepository.findAll();
            List<BangCong> bangCong= BangCongImport.convertExcelToListOfProduct(file.getInputStream(),ds);
            this.bangCongRepository.saveAll(bangCong);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<BangCong> findAllBangCong() {
        List<BangCong> bangCongs = bangCongRepository.findAll(Sort.by(Sort.Direction.ASC, "nhanVien"));
        return bangCongs;
    }
}
