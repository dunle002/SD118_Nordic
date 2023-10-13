package com.example.sd118_nordic.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@Table(name = "chat_lieu")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Chatlieu {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @Column(name = "ma")
    private String ma;
    @Column(name = "ten_chat_lieu")
    private String tenChatLieu;
    @Column(name = "trang_thai")
    private int trangThai;

}
