package com.example.de_mau_2.service.SanPham;

import com.example.de_mau_2.entity.SanPham.SanPham;
import com.example.de_mau_2.entity.SanPham.SanPhamRespone;
import com.example.de_mau_2.repository.SanPham.SanPhamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class SanPhamServie {
    @Autowired
    private SanPhamRepository sanPhamRepository;

    public Page<SanPhamRespone> findAllSanPhamRespne(int page, int size){
        Sort sort = Sort.by(Sort.Direction.DESC, "ma");
        return sanPhamRepository.findAllSanPhamRespne(PageRequest.of(page, size, sort));
    }

    public SanPham findSanPhamById(Integer id){
        return sanPhamRepository.findById(id).get();
    }

    public void deleteSanPham(Integer id){
        sanPhamRepository.deleteById(id);
    }

    public void add(SanPham sanPham){
        sanPhamRepository.save(sanPham);
    }
}
