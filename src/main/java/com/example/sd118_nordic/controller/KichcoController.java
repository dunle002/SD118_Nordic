package com.example.sd118_nordic.controller;

import com.example.sd118_nordic.entity.Kichco;
import com.example.sd118_nordic.entity.Mausac;
import com.example.sd118_nordic.entity.Sanpham;
import com.example.sd118_nordic.repository.KichcoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Controller
@RequestMapping("/kichco/")
public class KichcoController {
    @Autowired
    private KichcoRepository kichcoRepository;

    @GetMapping("hien-thi")
    private String getAll(@RequestParam(defaultValue = "0", name = "page") Integer number, Model model) {
        Pageable pageable = PageRequest.of(number, 5);
        Page<Kichco> listKichCo = kichcoRepository.findAll(pageable);
        model.addAttribute("listKichCo", listKichCo);
        return "kichco";
    }

    @GetMapping("delete/{id}")
    public String delete(@PathVariable("id") String id) {
        kichcoRepository.deleteById(UUID.fromString(id));
        return "redirect:/kichco/hien-thi";
    }

    @GetMapping("view-add")
    public String viewAdd(Model model) {
        List<Kichco> kichCo = kichcoRepository.findAll();
        model.addAttribute("kichCo", kichCo);
        return "addkichco";
    }

    @GetMapping("view-update/{id}")
    public String viewUpdate(@PathVariable("id") UUID id, Model model) {
        Optional<Kichco> kichCoOptional = kichcoRepository.findById(id);
        if (kichCoOptional.isPresent()) {
            Kichco kichCo = kichCoOptional.get();
            model.addAttribute("kichCo", kichCo);
        }
        return "updateKichco";
    }

    @PostMapping("add")
    public String addKichCo(@RequestParam("ma") String ma, @RequestParam("size") Integer size,
                            @RequestParam("trangThai") Integer trangThai) {
        Kichco kichCo = Kichco.builder()
                .ma(ma)
                .size(size)
                .trangThai(trangThai)
                .build();
        kichcoRepository.save(kichCo);
        return "redirect:/kichco/hien-thi";
    }

    @PostMapping("update")
    public String updateTaikhoan(@RequestParam("id") String id,
                                 @RequestParam("ma") String ma,
                                 @RequestParam("size") String size,
                                 @RequestParam("trangThai") String trangThai) {
        Kichco kichCo = kichcoRepository.findById(UUID.fromString(id))
                .orElseThrow(() -> new IllegalArgumentException("Invalid Kich co Id: " + id));
        kichCo.setMa(ma);
        kichCo.setSize(Integer.valueOf(size));
        kichCo.setTrangThai(Integer.valueOf(trangThai));
        kichcoRepository.save(kichCo);
        return "redirect:/kichco/hien-thi";
    }

}
