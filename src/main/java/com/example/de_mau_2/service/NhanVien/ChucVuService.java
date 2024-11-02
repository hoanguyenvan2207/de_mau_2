package com.example.de_mau_2.service.NhanVien;

import com.example.de_mau_2.entity.NhanVien.ChucVuRespone;
import com.example.de_mau_2.repository.NhanVien.ChucVuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChucVuService {
    @Autowired
    private ChucVuRepository chucVuRepository;

    public List<ChucVuRespone> findAllChucVu(){
        return  chucVuRepository.findAllChucVu();
    }
}
