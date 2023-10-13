package com.example.sd118_nordic.controller;

import com.example.sd118_nordic.entity.Sanpham;
import com.example.sd118_nordic.repository.SanphamRepository;
import com.example.sd118_nordic.service.SanphamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Controller
@RequestMapping("/sanpham/")
public class SanphamController {
    @Autowired
    private SanphamRepository sanPhamRepository;
    @Autowired
    private SanphamService service;

    @GetMapping("hien-thi")
    private String getAll(@RequestParam(defaultValue = "0", name = "page") Integer number, Model model) {
        Pageable pageable = PageRequest.of(number, 5);
        Page<Sanpham> listSanPham = sanPhamRepository.findAll(pageable);
        model.addAttribute("listSanPham", listSanPham);
        return "sanpham";
    }
//
//    @GetMapping("view-update/{id}")
//    public String viewUpdate(@PathVariable("id") String id, Model model) {
//        SanPham sanPham = sanPhamRepository.findById(UUID.fromString(id));
//    }

    @GetMapping("delete/{id}")
    public String delete(@PathVariable("id") String id) {
        sanPhamRepository.deleteById(UUID.fromString(id));
        return "redirect:/sanpham/hien-thi";
    }

    @GetMapping("view-add")
    public String viewAdd(Model model) {
        List<Sanpham> sanPhams = sanPhamRepository.findAll();
        model.addAttribute("sanPham", sanPhams);
        return "addsanpham";
    }

    @PostMapping("add")
    public String addSanPham(@RequestParam("ma") String ma, @RequestParam("tenSanPham") String tenSanPham,
                             @RequestParam("trangThai") Integer trangThai) {
        Sanpham sanPham = Sanpham.builder()
                .ma(ma)
                .tenSanPham(tenSanPham)
                .trangThai(trangThai)
                .build();
        sanPhamRepository.save(sanPham);
        return "redirect:/sanpham/hien-thi";
    }
//    @RequestMapping("/")
////    public String viewHomePage(Model model, @Param("keyword")String keyword) {
////        List<SanPham> list = service.listAll(keyword);
////        model.addAttribute("list", list);
////        model.addAttribute("keyword", keyword);
////        return "sanpham";
////    }
//    @GetMapping("/")
//    public String timKiem(Model model,@Param("keyword")String keyword) {
//        List<Sanpham> list =this.service.search(keyword);
//       if (keyword != null) {
//           list = this.service.search(keyword);
//        }
//        model.addAttribute("list", list);
//        return "timkiem";
//    }
//@GetMapping("/search")
//public List<Sanpham> searchProduct(@RequestParam("kw") Optional<String> kw){
//    String keyword = kw.orElse(null);
//    if(keyword != null) {
//        return service.findByName("%"+keyword+"%");
//    }else {
//        return service.findAll();
//    }
//}
}
