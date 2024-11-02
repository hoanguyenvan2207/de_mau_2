package com.example.de_mau_2.service.Phong;

import com.example.de_mau_2.entity.Phong.PhongRespone;
import com.example.de_mau_2.repository.Phong.PhongRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class PhongService {

    @Autowired
    private PhongRepo phongRepo;

    public Page<PhongRespone> findAll(int page, int size){
        Sort sort = Sort.by(Sort.Direction.ASC, "tenPhong");
        return phongRepo.getAllPhongRespone(PageRequest.of(page, size, sort));
    }

}
