package com.example.de_mau_2.repository.NhanVien;

import com.example.de_mau_2.entity.NhanVien.NhanVien;
import com.example.de_mau_2.entity.NhanVien.NhanVienRespone;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface NhanVienRepository extends JpaRepository<NhanVien, Integer> {
    @Query("""
    SELECT new com.example.de_mau_2.entity.NhanVien.NhanVienRespone(
    nv.id,
    nv.ma,
    nv.ten,
    nv.gioiTinh,
    nv.diaChi,
    nv.chucVu.id,
    nv.chucVu.ten
    )
    FROM NhanVien nv
        """)
    Page<NhanVienRespone> findAllNhanVienRes(Pageable pageable);

    Page<NhanVien> findNhanViensByTenContains(String ten, Pageable pageable);
}
