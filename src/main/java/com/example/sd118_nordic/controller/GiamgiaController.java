package com.example.sd118_nordic.controller;

import com.example.sd118_nordic.entity.Giamgia;
import com.example.sd118_nordic.entity.Taikhoan;
import com.example.sd118_nordic.repository.GiamgiaRepository;
import com.example.sd118_nordic.repository.TaikhoanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/giamgia/")
public class GiamgiaController {
    @Autowired
    private GiamgiaRepository giamgiaRepository;


    @GetMapping("hien-thi")
    private String getAll(@RequestParam(defaultValue = "0", name = "page") Integer number, Model model) {
        Pageable pageable = PageRequest.of(number, 5);
        Page<Giamgia> listGiamGia = giamgiaRepository.findAll(pageable);
        model.addAttribute("listGiamGia", listGiamGia);
        return "giamgia";
    }
//
//    @GetMapping("view-update/{id}")
//    public String viewUpdate(@PathVariable("id") String id, Model model) {
//        SanPham sanPham = sanPhamRepository.findById(UUID.fromString(id));
//    }

    @GetMapping("delete/{id}")
    public String delete(@PathVariable("id") String id) {
        giamgiaRepository.deleteById(UUID.fromString(id));
        return "redirect:/giamgia/hien-thi";
    }

    @GetMapping("view-add")
    public String viewAdd(Model model) {
        List<Giamgia> giamGia = giamgiaRepository.findAll();
        model.addAttribute("giamGia", giamGia);
        return "addgiamgia";
    }

    @PostMapping("add")
    public String addTaiKhoan(@RequestParam("ma") String ma,
                              @RequestParam("loaiGiamGia") String loaiGiamGia,
                              @RequestParam("giaTriGiam") BigDecimal giaTriGiam,
                              @RequestParam("ngayBatDau") String ngayBatDau,
                              @RequestParam("ngayKetThuc") String ngayKetThuc,
                              @RequestParam("trangThai") Integer trangThai) {
        Giamgia giamGia = Giamgia.builder()
                .ma(ma)
                .loaiGiamGia(loaiGiamGia)
                .giaTriGiam(giaTriGiam)
                .ngayBatDau(Date.valueOf(ngayBatDau))
                .ngayKetThuc(Date.valueOf(ngayKetThuc))
                .trangThai(trangThai)
                .build();
        giamgiaRepository.save(giamGia);
        return "redirect:/giamgia/hien-thi";
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
