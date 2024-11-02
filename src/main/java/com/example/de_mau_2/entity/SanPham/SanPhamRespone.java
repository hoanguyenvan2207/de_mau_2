package com.example.de_mau_2.entity.SanPham;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SanPhamRespone {

    private Integer id;

    private String ma;

    private Integer giaBan;

    private Integer soLuong;

    private Boolean trangThai;

    private Integer IdLoaiSp;

    private String tenLoaiSanPham;
}
