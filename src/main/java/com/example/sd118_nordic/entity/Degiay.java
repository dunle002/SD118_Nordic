package com.example.sd118_nordic.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;


@Entity
@Table(name = "de_giay")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Degiay {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @Column(name = "ma")
    private String ma;
    @Column(name = "loai_de")
    private String loaiDe;
    @Column(name = "trang_thai")
    private int trangThai;
}
