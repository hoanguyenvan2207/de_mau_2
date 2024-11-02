package com.example.de_mau_2.repository.Phong;

import com.example.de_mau_2.entity.Phong.Phong;
import com.example.de_mau_2.entity.Phong.PhongRespone;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PhongRepo extends JpaRepository<Phong, Integer> {
    @Query("""
    SELECT new com.example.de_mau_2.entity.Phong.PhongRespone(
        p.id,
        p.tenPhong,
        p.soLuongPhong,
        p.trangThai,
        p.ghiChu,
        p.loaiPhong.id,
        p.loaiPhong.tenLoaiPhong
        )
    FROM Phong p
    """)
    Page<PhongRespone> getAllPhongRespone(Pageable pageable);
}
