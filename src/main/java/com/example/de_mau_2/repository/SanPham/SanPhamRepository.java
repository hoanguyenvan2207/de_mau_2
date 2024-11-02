package com.example.de_mau_2.repository.SanPham;

import com.example.de_mau_2.entity.SanPham.SanPham;
import com.example.de_mau_2.entity.SanPham.SanPhamRespone;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface SanPhamRepository extends JpaRepository<SanPham, Integer> {

    @Query("""
        SELECT new com.example.de_mau_2.entity.SanPham.SanPhamRespone(
        sp.id,
        sp.ma,
        sp.giaBan,
        sp.soLuong,
        sp.trangThai,
        sp.loaiSanPham.id,
        sp.loaiSanPham.ten
        )
        FROM SanPham sp
        """)
    Page<SanPhamRespone> findAllSanPhamRespne(Pageable pageable);

    @Query("""
        SELECT new com.example.de_mau_2.entity.SanPham.SanPhamRespone(
        sp.id,
        sp.ma,
        sp.giaBan,
        sp.soLuong,
        sp.trangThai,
        sp.loaiSanPham.id,
        sp.loaiSanPham.ten
        )
        FROM SanPham sp
        WHERE sp.id = :id
        """)
   SanPhamRespone findSanPhamRespneById(@Param("id") Integer id);
}
