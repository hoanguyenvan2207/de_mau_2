package com.example.de_mau_2.repository.NhanVien;

import com.example.de_mau_2.entity.NhanVien.ChucVu;
import com.example.de_mau_2.entity.NhanVien.ChucVuRespone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChucVuRepository extends JpaRepository<ChucVu, Integer> {

    @Query("""
    SELECT new com.example.de_mau_2.entity.NhanVien.ChucVuRespone(
    cv.id,
    cv.ten
    )
    FROM ChucVu cv
    """)
    List<ChucVuRespone> findAllChucVu();
}
