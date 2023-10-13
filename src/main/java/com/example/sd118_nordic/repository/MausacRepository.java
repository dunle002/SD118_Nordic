package com.example.sd118_nordic.repository;

import com.example.sd118_nordic.entity.Mausac;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface MausacRepository extends JpaRepository<Mausac, UUID> {
}
