package com.example.demo.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.example.demo.model.BangCong;

public interface BangCongService {
    public void saveFile(MultipartFile file);
    List<BangCong> findAllBangCong();
}
