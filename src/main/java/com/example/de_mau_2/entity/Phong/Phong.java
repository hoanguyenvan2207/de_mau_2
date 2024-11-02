package com.example.de_mau_2.entity.Phong;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "phong")
public class Phong {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String tenPhong;

    private String soLuongPhong;

    private String trangThai;

    private String ghiChu;

    @ManyToOne
    @JoinColumn(name = "idLoaiPhong", referencedColumnName = "id")
    private LoaiPhong loaiPhong;
}
