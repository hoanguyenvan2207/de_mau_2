package com.example.de_mau_2.entity.Phong;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "loaiPhong")
public class LoaiPhong {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String tenLoaiPhong;
}
