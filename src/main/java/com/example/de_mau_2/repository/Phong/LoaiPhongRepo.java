package com.example.de_mau_2.repository.Phong;

import com.example.de_mau_2.entity.Phong.LoaiPhong;
import com.example.de_mau_2.entity.Phong.LoaiPhongRespone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LoaiPhongRepo extends JpaRepository<LoaiPhong, Integer> {
    @Query("""
        SELECT new com.example.de_mau_2.entity.Phong.LoaiPhongRespone(
        lp.id,
        lp.tenLoaiPhong
        )
        FROM LoaiPhong lp
        """)
    List<LoaiPhongRespone> getAllLoaiPhongRespone();
}
