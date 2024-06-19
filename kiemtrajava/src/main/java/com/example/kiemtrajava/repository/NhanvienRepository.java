package com.example.kiemtrajava.repository;

import com.example.kiemtrajava.model.Nhanvien;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface NhanvienRepository extends JpaRepository<Nhanvien, Long> {
}
