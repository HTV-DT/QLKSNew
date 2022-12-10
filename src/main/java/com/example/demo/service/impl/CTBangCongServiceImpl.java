package com.example.demo.service.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.helper.BangCongImport;
import com.example.demo.model.CTBangCong;
import com.example.demo.model.NhanVien;
import com.example.demo.repository.CTBangCongRepository;
import com.example.demo.repository.NhanVienRepository;
import com.example.demo.service.CTBangCongService;

@Service
public class CTBangCongServiceImpl implements CTBangCongService{
    @Autowired
    CTBangCongRepository ctBangCongRepository;
    @Autowired //tự động truyền tải các mối quan hệ
    NhanVienRepository nhanVienRepository;
    @Override
    public void saveFile(MultipartFile file) {
        try {
            List<NhanVien> ds = nhanVienRepository.findAll();
            List<CTBangCong> bangCong= BangCongImport.convertExcelToListOfProduct(file.getInputStream(),ds);
            ctBangCongRepository.saveAll(bangCong);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<CTBangCong> findAllBangCong() {
        List<CTBangCong> bangCongs = ctBangCongRepository.findAll(Sort.by(Sort.Direction.ASC, "nv"));
        return bangCongs;
    }
}
