package com.example.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Phong;
import com.example.demo.repository.PhongRepository;

import com.example.demo.service.PhongService;


@Service
public class PhongServiceImpl implements PhongService {
    @Autowired
    PhongRepository phongRepository;
   
   
    @Override
    public List<Phong> findAllPhong() {
        List<Phong> users = phongRepository.findAll();
        return users;
    }
}
