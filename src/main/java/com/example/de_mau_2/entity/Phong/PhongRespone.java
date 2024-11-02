package com.example.de_mau_2.entity.Phong;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PhongRespone {

    private Integer id;

    private String tenPhong;

    private String soLuongPhong;

    private String trangThai;

    private String ghiChu;

    private Integer IdloaiPhong;

    private String tenLoaiPhong;
}
