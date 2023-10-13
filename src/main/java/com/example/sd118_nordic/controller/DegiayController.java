package com.example.sd118_nordic.controller;

import com.example.sd118_nordic.entity.Degiay;
import com.example.sd118_nordic.entity.Sanpham;
import com.example.sd118_nordic.repository.DegiayRepository;
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
import java.util.UUID;

@Controller
@RequestMapping("/degiay/")
public class DegiayController {
    @Autowired
    private DegiayRepository degiayRepository;


    @GetMapping("hien-thi")
    private String getAll(@RequestParam(defaultValue = "0", name = "page") Integer number, Model model) {
        Pageable pageable = PageRequest.of(number, 5);
        Page<Degiay> listDeGiay = degiayRepository.findAll(pageable);
        model.addAttribute("listDeGiay", listDeGiay);
        return "degiay";
    }


    @GetMapping("delete/{id}")
    public String delete(@PathVariable("id") String id) {
        degiayRepository.deleteById(UUID.fromString(id));
        return "redirect:/degiay/hien-thi";
    }

    @GetMapping("view-add")
    public String viewAdd(Model model) {
        List<Degiay> deGiay = degiayRepository.findAll();
        model.addAttribute("deGiay", deGiay);
        return "adddegiay";
    }

    @PostMapping("add")
    public String addDeGiay(@RequestParam("ma") String ma, @RequestParam("loaiDe") String loaiDe,
                             @RequestParam("trangThai") Integer trangThai) {
        Degiay deGiay = Degiay.builder()
                .ma(ma)
                .loaiDe(loaiDe)
                .trangThai(trangThai)
                .build();
        degiayRepository.save(deGiay);
        return "redirect:/degiay/hien-thi";
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
