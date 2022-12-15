package com.example.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.LuongRepository;
import com.example.demo.service.LuongService;

@Service
public class LuongServiceImpl implements LuongService{

    @Autowired
    LuongRepository luongRepository;

    

}
