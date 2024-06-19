package com.example.kiemtrajava.repository;

import com.example.kiemtrajava.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
    User findByEmail(String email); // Thêm phương thức tìm kiếm bằng email
}
