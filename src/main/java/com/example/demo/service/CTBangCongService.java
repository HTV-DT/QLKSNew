package com.example.demo.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.example.demo.model.CTBangCong;

public interface CTBangCongService {
    public void saveFile(MultipartFile file);
    List<CTBangCong> findAllBangCong();
}
