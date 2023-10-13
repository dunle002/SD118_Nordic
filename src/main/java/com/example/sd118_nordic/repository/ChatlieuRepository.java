package com.example.sd118_nordic.repository;

import com.example.sd118_nordic.entity.Chatlieu;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ChatlieuRepository extends JpaRepository<Chatlieu, UUID> {

}
