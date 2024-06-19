package com.example.kiemtrajava.service;

import com.example.kiemtrajava.model.Phongban;
import com.example.kiemtrajava.repository.PhongbanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PhongbanService {

    private final PhongbanRepository phongbanRepository;

    @Autowired
    public PhongbanService(PhongbanRepository phongbanRepository) {
        this.phongbanRepository = phongbanRepository;
    }

    public List<Phongban> getAllPhongban() {
        return phongbanRepository.findAll();
    }

    public Optional<Phongban> getPhongbanById(Long id) {
        return phongbanRepository.findById(id);
    }

    public Phongban addPhongban(Phongban phongban) {
        return phongbanRepository.save(phongban);
    }

    public Phongban updatePhongban(Phongban phongban) {
        Phongban existingPhongban = phongbanRepository.findById(phongban.getId())
                .orElseThrow(() -> new IllegalStateException("Department with MaPhong " +
                        phongban.getMaPhong() + " does not exist."));
        existingPhongban.setTenPhong(phongban.getTenPhong());
        existingPhongban.setNhanviens(phongban.getNhanviens());
        return phongbanRepository.save(existingPhongban);
    }

    public void deletePhongbanById(Long id) {
        phongbanRepository.deleteById(id);
    }
}

