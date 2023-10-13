package com.example.sd118_nordic.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;


@Entity
@Table(name = "loai_giay")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Loaigiay {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @Column(name = "ma")
    private String ma;
    @Column(name = "ten_the_loai")
    private String tenTheLoai;
    @Column(name = "trang_thai")
    private int trangThai;
}
