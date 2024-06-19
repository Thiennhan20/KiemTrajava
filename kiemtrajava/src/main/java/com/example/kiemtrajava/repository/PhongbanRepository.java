package com.example.kiemtrajava.repository;

import com.example.kiemtrajava.model.Phongban;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PhongbanRepository extends JpaRepository<Phongban, Long> {
}
