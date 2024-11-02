package com.example.de_mau_2.service.SanPham;

import com.example.de_mau_2.entity.SanPham.LoaiSanPhamRespone;
import com.example.de_mau_2.repository.SanPham.LoaiSanPhamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoaiSanPhamService {

    @Autowired
    private LoaiSanPhamRepository loaiSanPhamRepository;

    public List<LoaiSanPhamRespone> findAllLoaiSanPhamRespone(){
        return loaiSanPhamRepository.findAllLoaiSanPhamRespone();
    }

    public LoaiSanPhamRespone findLoaiSanPhamResponeById(Integer id){
        return loaiSanPhamRepository.findLoaiSanPhamResponeById(id);
    }
}
