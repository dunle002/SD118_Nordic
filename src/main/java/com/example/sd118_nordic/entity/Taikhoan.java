package com.example.sd118_nordic.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;


@Entity
@Table(name = "tai_khoan")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Taikhoan {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @Column(name = "user_name")
    private String userName;
    @Column(name = "password")
    private String password;
    @Column(name = "role")
    private Boolean role;
}
