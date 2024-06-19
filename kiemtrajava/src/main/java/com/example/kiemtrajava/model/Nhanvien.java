package com.example.kiemtrajava.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "nhanviens")
public class Nhanvien {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NotNull
    @Column(name = "MaNV")
    private String MaNV;

    @NotNull
    @Column(name = "TenNV")
    private String TenNV;

    @NotNull
    @Column(name = "Phai")
    private String Phai;

    @NotNull
    @Column(name = "NoiSinh")
    private String NoiSinh;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "phongban_MaPhong", nullable = false)
    private Phongban phongban;

    @NotNull
    @Column(name = "Luong")
    private Integer Luong;

    // Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMaNV() {
        return MaNV;
    }

    public void setMaNV(String maNV) {
        MaNV = maNV;
    }

    public String getTenNV() {
        return TenNV;
    }

    public void setTenNV(String tenNV) {
        TenNV = tenNV;
    }

    public String getPhai() {
        return Phai;
    }

    public void setPhai(String phai) {
        Phai = phai;
    }

    public String getNoiSinh() {
        return NoiSinh;
    }

    public void setNoiSinh(String noiSinh) {
        NoiSinh = noiSinh;
    }

    public Phongban getPhongban() {
        return phongban;
    }

    public void setPhongban(Phongban phongban) {
        this.phongban = phongban;
    }

    public Integer getLuong() {
        return Luong;
    }

    public void setLuong(Integer luong) {
        Luong = luong;
    }
}

