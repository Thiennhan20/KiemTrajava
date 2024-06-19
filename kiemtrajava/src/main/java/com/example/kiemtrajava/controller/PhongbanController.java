package com.example.kiemtrajava.controller;

import com.example.kiemtrajava.model.Phongban;
import com.example.kiemtrajava.service.PhongbanService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/phongbans")
public class PhongbanController {

    private final PhongbanService phongbanService;

    // Endpoint to show form for adding a new phòng ban
    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("phongban", new Phongban());
        return "phongbans/add-phongban";
    }

    // Endpoint to handle adding a new phòng ban
    @PostMapping("/add")
    public String addPhongban(@Valid @ModelAttribute("phongban") Phongban phongban, BindingResult result) {
        if (result.hasErrors()) {
            return "phongbans/add-phongban";
        }
        phongbanService.addPhongban(phongban);
        return "redirect:/phongbans";
    }

    // Endpoint to display list of phòng ban
    @GetMapping
    public String listPhongbans(Model model) {
        List<Phongban> phongbans = phongbanService.getAllPhongban();
        model.addAttribute("phongbans", phongbans);
        return "phongbans/phongban-list";
    }

    // Endpoint to show form for editing a phòng ban
    @GetMapping("/edit/{id}")
    public String showUpdateForm(@PathVariable Long id, Model model) {
        Phongban phongban = phongbanService.getPhongbanById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid phòng ban id:" + id));
        model.addAttribute("phongban", phongban);
        return "phongbans/update-phongban";
    }

    // Endpoint to handle updating a phòng ban
    @PostMapping("/update/{id}")
    public String updatePhongban(@PathVariable Long id, @Valid @ModelAttribute("phongban") Phongban phongban,
                                 BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "phongbans/update-phongban";
        }
        phongban.setId(id);
        phongbanService.updatePhongban(phongban);
        return "redirect:/phongbans";
    }

    // Endpoint to delete a phòng ban
    @GetMapping("/delete/{id}")
    public String deletePhongban(@PathVariable Long id) {
        phongbanService.deletePhongbanById(id);
        return "redirect:/phongbans";
    }
}

