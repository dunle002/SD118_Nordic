package com.example.sd118_nordic.controller;

import com.example.sd118_nordic.entity.Chatlieu;
import com.example.sd118_nordic.entity.Degiay;
import com.example.sd118_nordic.entity.Sanpham;
import com.example.sd118_nordic.repository.ChatlieuRepository;
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
@RequestMapping("/chatlieu/")
public class ChatlieuController {
    @Autowired
    private ChatlieuRepository chatlieuRepository;
    @GetMapping("hien-thi")
    private String getAll(@RequestParam(defaultValue = "0",name = "page")Integer number, Model model){
        Pageable pageable = PageRequest.of(number, 5);
        Page<Chatlieu> listChatlieu = chatlieuRepository.findAll(pageable);
        model.addAttribute("listChatLieu",listChatlieu);
        return "chatlieu";
    }
    @GetMapping("delete/{id}")
    public String delete(@PathVariable("id") String id) {
        chatlieuRepository.deleteById(UUID.fromString(id));
        return "redirect:/chatlieu/hien-thi";
    }
    @GetMapping("view-add")
    public String viewAdd(Model model) {
        List<Chatlieu> chatlieu = chatlieuRepository.findAll();
        model.addAttribute("chatLieu", chatlieu);
        return "addchatlieu";
    }
    @GetMapping("view-update/{id}")
    public String viewUpdate(@PathVariable("id") UUID id, Model model) {
        Optional<Chatlieu> chatLieuOptional = chatlieuRepository.findById(id);
        if (chatLieuOptional.isPresent()) {
            Chatlieu chatLieu = chatLieuOptional.get();
            model.addAttribute("chatLieu", chatLieu);
        }
        return "updateChatlieu";
    }
    @PostMapping("add")
    public String addChatLieu(@RequestParam("ma") String ma, @RequestParam("tenChatLieu") String tenChatLieu,
                             @RequestParam("trangThai") Integer trangThai) {
        Chatlieu chatlieu = Chatlieu.builder()
                .ma(ma)
                .tenChatLieu(tenChatLieu)
                .trangThai(trangThai)
                .build();
        chatlieuRepository.save(chatlieu);
        return "redirect:/chatlieu/hien-thi";
    }
    @PostMapping("update")
    public String updateChatlieu(@RequestParam("id") String id,
                                 @RequestParam("ma") String ma,
                                 @RequestParam("tenChatLieu") String tenChatLieu,
                                 @RequestParam("trangThai") String trangThai) {
        Chatlieu chatlieu = chatlieuRepository.findById(UUID.fromString(id))
                .orElseThrow(() -> new IllegalArgumentException("Invalid Chat lieu Id: " + id));
        chatlieu.setMa(ma);
        chatlieu.setTenChatLieu(tenChatLieu);
        chatlieu.setTrangThai(Integer.valueOf(trangThai));
        chatlieuRepository.save(chatlieu);
        return "redirect:/chatlieu/hien-thi";
    }
}
