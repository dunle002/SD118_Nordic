package com.example.sd118_nordic.repository;


import com.example.sd118_nordic.entity.Loaigiay;
import com.example.sd118_nordic.entity.Sanpham;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface LoaigiayRepository extends JpaRepository<Loaigiay, UUID> {
//    @Query("SELECT p FROM Sanpham p WHERE p.tenSanPham LIKE :tenSanPham")
//    public List<Sanpham> findByName(@Param("tenSanPham") String tenSanPham);

//    @Query("SELECT p FROM Sanpham p WHERE p.tenSanPham LIKE :tenSanPham")
//    public Page<Sanpham> findByKeyword(@Param("name") String name, Pageable pageable);
}
