package com.example.sd118_nordic.repository;

import com.example.sd118_nordic.entity.Degiay;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface DegiayRepository extends JpaRepository<Degiay, UUID> {
}
