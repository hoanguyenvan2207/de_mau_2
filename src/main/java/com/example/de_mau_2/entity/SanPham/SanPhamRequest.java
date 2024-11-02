package com.example.de_mau_2.entity.SanPham;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SanPhamRequest {

    private Integer id;

    @NotBlank(message = "Khong duoc de trong ma!")
    private String ma;

    @NotNull(message = "Khong duoc de trong gia!")
    private Integer giaBan;

    @NotNull(message = "Khong duoc de trong so luong!")
    private Integer soLuong;

    private Boolean trangThai;

    private LoaiSanPham loaiSanPham;
}
