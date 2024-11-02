package com.example.de_mau_2.entity.NhanVien;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "nhan_vien")
public class NhanVien {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String ma;

    private String ten;

    private String gioiTinh;

    private String diaChi;

    @ManyToOne
    @JoinColumn(name = "id_cv", referencedColumnName = "id")
    private ChucVu chucVu;
}
