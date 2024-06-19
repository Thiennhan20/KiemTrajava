package com.example.kiemtrajava.service;

import com.example.kiemtrajava.model.Nhanvien;
import com.example.kiemtrajava.model.Phongban;
import com.example.kiemtrajava.repository.NhanvienRepository;
import com.example.kiemtrajava.repository.PhongbanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NhanvienService {

    private final NhanvienRepository nhanvienRepository;
    private final PhongbanRepository phongbanRepository;

    @Autowired
    public NhanvienService(NhanvienRepository nhanvienRepository, PhongbanRepository phongbanRepository) {
        this.nhanvienRepository = nhanvienRepository;
        this.phongbanRepository = phongbanRepository;
    }

    public List<Nhanvien> getAllNhanvien() {
        return nhanvienRepository.findAll();
    }

    public Optional<Nhanvien> getNhanvienById(Long id) {
        return nhanvienRepository.findById(id);
    }

    public Nhanvien addNhanvien(Nhanvien nhanvien) {
        Long phongbanId = nhanvien.getPhongban().getId();
        Phongban phongban = phongbanRepository.findById(phongbanId)
                .orElseThrow(() -> new IllegalArgumentException("Invalid Phongban ID"));

        nhanvien.setPhongban(phongban);

        return nhanvienRepository.save(nhanvien);
    }

    public Nhanvien updateNhanvien(Nhanvien nhanvien) {
        Optional<Nhanvien> optionalNhanvien = nhanvienRepository.findById(nhanvien.getId());
        if (optionalNhanvien.isEmpty()) {
            throw new IllegalStateException("Nhanvien with id " + nhanvien.getId() + " does not exist.");
        }

        return nhanvienRepository.save(nhanvien);
    }

    public void deleteNhanvienById(Long id) {
        if (!nhanvienRepository.existsById(id)) {
            throw new IllegalStateException("Nhanvien with id " + id + " does not exist.");
        }
        nhanvienRepository.deleteById(id);
    }

    public Page<Nhanvien> getNhanviensPaginated(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return nhanvienRepository.findAll(pageable);
    }

}
