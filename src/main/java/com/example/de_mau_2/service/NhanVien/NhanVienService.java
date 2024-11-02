package com.example.de_mau_2.service.NhanVien;

import com.example.de_mau_2.entity.NhanVien.NhanVien;
import com.example.de_mau_2.entity.NhanVien.NhanVienRespone;
import com.example.de_mau_2.repository.NhanVien.NhanVienRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class NhanVienService {
    @Autowired
    private NhanVienRepository nhanVienRepository;

    public Page<NhanVienRespone> findAllNhanVienRes(int page, int size){
        Sort sort = Sort.by(Sort.Direction.DESC, "id");
        return nhanVienRepository.findAllNhanVienRes(PageRequest.of(page, size, sort));
    }

    public Page<NhanVienRespone> findNhanVienByTen(String ten, int page, int size){
        Page<NhanVien> dsNhanVien = nhanVienRepository.findNhanViensByTenContains(ten, PageRequest.of(page, size));
        List<NhanVienRespone> dsNhanVienRes = new ArrayList<>();
        for(NhanVien nhanVien: dsNhanVien){
            dsNhanVienRes.add(new NhanVienRespone(
                    nhanVien.getId(),
                    nhanVien.getMa(),
                    nhanVien.getTen(),
                    nhanVien.getGioiTinh(),
                    nhanVien.getDiaChi(),
                    nhanVien.getChucVu().getId(),
                    nhanVien.getChucVu().getTen()
            ));
        }
        return new PageImpl<>(dsNhanVienRes, dsNhanVien.getPageable(), dsNhanVien.getTotalElements());
    }

    public NhanVien findNhanVienById(Integer id){
        return nhanVienRepository.findById(id).get();
    }

    public void addNhanVien(NhanVien nv){
        nhanVienRepository.save(nv);
    }

    public void deleteNhanVien(Integer id){
        nhanVienRepository.deleteById(id);
    }
}
