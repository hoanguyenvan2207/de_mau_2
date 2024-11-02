package com.example.de_mau_2.entity.NhanVien;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class NhanVienRequest {
    private Integer id;

    private String ma;

    private String ten;

    private String gioiTinh;

    private String diaChi;

    private ChucVu chucVu;
}
