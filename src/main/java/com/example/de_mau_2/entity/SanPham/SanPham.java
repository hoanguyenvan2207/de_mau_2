package com.example.de_mau_2.entity.SanPham;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "san_pham")
public class SanPham {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String ma;

    private Integer giaBan;

    private Integer soLuong;

    private Boolean trangThai;

    @ManyToOne
    @JoinColumn(name = "id_loai_sp", referencedColumnName = "id")
    private LoaiSanPham loaiSanPham;
}
