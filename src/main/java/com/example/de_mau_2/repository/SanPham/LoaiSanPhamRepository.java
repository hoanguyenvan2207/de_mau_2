package com.example.de_mau_2.repository.SanPham;

import com.example.de_mau_2.entity.SanPham.LoaiSanPham;
import com.example.de_mau_2.entity.SanPham.LoaiSanPhamRespone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LoaiSanPhamRepository extends JpaRepository<LoaiSanPham, Integer> {

    @Query("""
        SELECT new com.example.de_mau_2.entity.SanPham.LoaiSanPhamRespone(
        lsp.id,
        lsp.ten
        )
        FROM LoaiSanPham lsp
        """)
    List<LoaiSanPhamRespone> findAllLoaiSanPhamRespone();

    @Query("""
        SELECT new com.example.de_mau_2.entity.SanPham.LoaiSanPhamRespone(
        lsp.id,
        lsp.ten
        )
        FROM LoaiSanPham lsp
        WHERE lsp.id = :id
        """)
    LoaiSanPhamRespone findLoaiSanPhamResponeById(@Param("id") Integer id);
}
