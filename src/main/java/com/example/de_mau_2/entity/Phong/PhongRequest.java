package com.example.de_mau_2.entity.Phong;

import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PhongRequest {

    private Integer id;

    private String tenPhong;

    @Pattern(regexp = "\\d+" , message = "So luong phai la so!")
    private String soLuongPhong;

    private String trangThai;

    private String ghiChu;

    private Integer IdLoaiPhong;

}
