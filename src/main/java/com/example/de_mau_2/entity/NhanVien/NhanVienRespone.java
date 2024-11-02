package com.example.de_mau_2.entity.NhanVien;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class NhanVienRespone {
    private Integer id;

    private String ma;

    private String ten;

    private String gioiTinh;

    private String diaChi;

    private Integer IdChucVu;

    private String TenChucVu;
}
