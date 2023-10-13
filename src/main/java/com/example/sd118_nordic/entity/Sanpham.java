package com.example.sd118_nordic.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;


@Entity
@Table(name = "san_pham")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Sanpham {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @Column(name = "ma")
    private String ma;
    @Column(name = "ten_san_pham")
    private String tenSanPham;
    @Column(name = "trang_thai")
    private int trangThai;
}
