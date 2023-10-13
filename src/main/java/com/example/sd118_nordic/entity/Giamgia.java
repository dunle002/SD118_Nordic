package com.example.sd118_nordic.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.Date;
import java.util.UUID;


@Entity
@Table(name = "giam_gia")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Giamgia {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @Column(name = "ma")
    private String ma;
    @Column(name = "loai_giam_gia")
    private String loaiGiamGia;
    @Column(name = "gia_tri_giam")
    private BigDecimal giaTriGiam;
    @Column(name = "ngay_bat_dau")
    private Date ngayBatDau;
    @Column(name = "ngay_ket_thuc")
    private Date ngayKetThuc;
    @Column(name = "trang_thai")
    private int trangThai;

}
