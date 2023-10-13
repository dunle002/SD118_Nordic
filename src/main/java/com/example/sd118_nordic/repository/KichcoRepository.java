package com.example.sd118_nordic.repository;

import com.example.sd118_nordic.entity.Kichco;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface KichcoRepository extends JpaRepository<Kichco, UUID> {
}
