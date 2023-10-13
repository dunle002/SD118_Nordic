package com.example.sd118_nordic.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;


@Entity
@Table(name = "mau_sac")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Mausac {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @Column(name = "ma")
    private String ma;
    @Column(name = "ten_mau")
    private String tenMau;
    @Column(name = "trang_thai")
    private int trangThai;
}
