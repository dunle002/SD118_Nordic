package com.example.sd118_nordic.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@Table(name = "kich_co")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Kichco {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @Column(name = "ma")
    private String ma;
    @Column(name = "size")
    private int size;
    @Column(name = "trang_thai")
    private int trangThai;
}
