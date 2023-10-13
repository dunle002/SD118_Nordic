package com.example.sd118_nordic.repository;

import com.example.sd118_nordic.entity.Giamgia;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface GiamgiaRepository extends JpaRepository<Giamgia, UUID> {
}
