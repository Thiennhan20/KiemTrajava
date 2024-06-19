package com.example.kiemtrajava.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.List;

@Entity
@Table(name = "phongbans")
public class Phongban {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NotNull
    @Column(name = "MaPhong")
    private String MaPhong;

    @NotNull
    @Column(name = "TenPhong")
    private String TenPhong;

    @OneToMany(mappedBy = "phongban", cascade = CascadeType.ALL)
    private List<Nhanvien> nhanviens;

    // Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMaPhong() {
        return MaPhong;
    }

    public void setMaPhong(String maPhong) {
        MaPhong = maPhong;
    }

    public String getTenPhong() {
        return TenPhong;
    }

    public void setTenPhong(String tenPhong) {
        TenPhong = tenPhong;
    }

    public List<Nhanvien> getNhanviens() {
        return nhanviens;
    }

    public void setNhanviens(List<Nhanvien> nhanviens) {
        this.nhanviens = nhanviens;
    }
}

