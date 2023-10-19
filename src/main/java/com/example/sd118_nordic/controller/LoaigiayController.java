package com.example.sd118_nordic.controller;

import com.example.sd118_nordic.entity.Loaigiay;
import com.example.sd118_nordic.entity.Mausac;
import com.example.sd118_nordic.entity.Sanpham;
import com.example.sd118_nordic.repository.LoaigiayRepository;
import com.example.sd118_nordic.repository.SanphamRepository;
import com.example.sd118_nordic.service.SanphamService;
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
@RequestMapping("/loaigiay/")
public class LoaigiayController {
    @Autowired
    private LoaigiayRepository loaigiayRepository;


    @GetMapping("hien-thi")
    private String getAll(@RequestParam(defaultValue = "0", name = "page") Integer number, Model model) {
        Pageable pageable = PageRequest.of(number, 5);
        Page<Loaigiay> listLoaiGiay = loaigiayRepository.findAll(pageable);
        model.addAttribute("listLoaiGiay", listLoaiGiay);
        return "loaigiay";
    }
    @GetMapping("view-update/{id}")
    public String viewUpdate(@PathVariable("id") UUID id, Model model) {
        Optional<Loaigiay> loaiGiayOptional = loaigiayRepository.findById(id);
        if (loaiGiayOptional.isPresent()) {
            Loaigiay loaiGiay = loaiGiayOptional.get();
            model.addAttribute("loaiGiay", loaiGiay);
        }
        return "updateLoaigiay";
    }

    @GetMapping("delete/{id}")
    public String delete(@PathVariable("id") String id) {
        loaigiayRepository.deleteById(UUID.fromString(id));
        return "redirect:/loaigiay/hien-thi";
    }

    @GetMapping("view-add")
    public String viewAdd(Model model) {
        List<Loaigiay> loaiGiay = loaigiayRepository.findAll();
        model.addAttribute("loaiGiay", loaiGiay);
        return "addloaigiay";
    }

    @PostMapping("add")
    public String addLoaiGiay(@RequestParam("ma") String ma, @RequestParam("tenTheLoai") String tenTheLoai,
                             @RequestParam("trangThai") Integer trangThai) {
        Loaigiay loaiGiay = Loaigiay.builder()
                .ma(ma)
                .tenTheLoai(tenTheLoai)
                .trangThai(trangThai)
                .build();
        loaigiayRepository.save(loaiGiay);
        return "redirect:/loaigiay/hien-thi";
    }
    @PostMapping("update")
    public String updateLoaigiay(@RequestParam("id") String id,
                                 @RequestParam("ma") String ma,
                                 @RequestParam("tenTheLoai") String tenTheLoai,
                                 @RequestParam("trangThai") String trangThai) {
        Loaigiay loaiGiay = loaigiayRepository.findById(UUID.fromString(id))
                .orElseThrow(() -> new IllegalArgumentException("Invalid Mau sac Id: " + id));
        loaiGiay.setMa(ma);
        loaiGiay.setTenTheLoai(tenTheLoai);
        loaiGiay.setTrangThai(Integer.valueOf(trangThai));
        loaigiayRepository.save(loaiGiay);
        return "redirect:/loaigiay/hien-thi";
    }

}
