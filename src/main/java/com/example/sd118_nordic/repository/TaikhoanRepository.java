package com.example.sd118_nordic.repository;

import com.example.sd118_nordic.entity.Taikhoan;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface TaikhoanRepository extends JpaRepository<Taikhoan, UUID> {
}
