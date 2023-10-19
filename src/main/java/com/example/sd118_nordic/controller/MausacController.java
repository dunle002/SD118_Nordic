package com.example.sd118_nordic.controller;

import com.example.sd118_nordic.entity.Mausac;
import com.example.sd118_nordic.entity.Sanpham;
import com.example.sd118_nordic.entity.Taikhoan;
import com.example.sd118_nordic.repository.MausacRepository;
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
@RequestMapping("/mausac/")
public class MausacController {
    @Autowired
    private MausacRepository mausacRepository;
;

    @GetMapping("hien-thi")
    private String getAll(@RequestParam(defaultValue = "0", name = "page") Integer number, Model model) {
        Pageable pageable = PageRequest.of(number, 5);
        Page<Mausac> listMauSac = mausacRepository.findAll(pageable);
        model.addAttribute("listMauSac", listMauSac);
        return "mausac";
    }
    @GetMapping("view-update/{id}")
    public String viewUpdate(@PathVariable("id") UUID id, Model model) {
        Optional<Mausac> mauSacOptional = mausacRepository.findById(id);
        if (mauSacOptional.isPresent()) {
            Mausac mauSac = mauSacOptional.get();
            model.addAttribute("mauSac", mauSac);
        }
        return "updateMausac";
    }

    @GetMapping("delete/{id}")
    public String delete(@PathVariable("id") String id) {
        mausacRepository.deleteById(UUID.fromString(id));
        return "redirect:/mausac/hien-thi";
    }

    @GetMapping("view-add")
    public String viewAdd(Model model) {
        List<Mausac> mauSac = mausacRepository.findAll();
        model.addAttribute("mauSac", mauSac);
        return "addmausac";
    }

    @PostMapping("add")
    public String addSanPham(@RequestParam("ma") String ma, @RequestParam("tenMau") String tenMau,
                             @RequestParam("trangThai") Integer trangThai) {
        Mausac mauSac = Mausac.builder()
                .ma(ma)
                .tenMau(tenMau)
                .trangThai(trangThai)
                .build();
        mausacRepository.save(mauSac);
        return "redirect:/mausac/hien-thi";
    }
    @PostMapping("update")
    public String updateMausac(@RequestParam("id") String id,
                                 @RequestParam("ma") String ma,
                                 @RequestParam("tenMau") String tenMau,
                                 @RequestParam("trangThai") String trangThai) {
        Mausac mauSac = mausacRepository.findById(UUID.fromString(id))
                .orElseThrow(() -> new IllegalArgumentException("Invalid Mau sac Id: " + id));
        mauSac.setMa(ma);
        mauSac.setTenMau(tenMau);
        mauSac.setTrangThai(Integer.valueOf(trangThai));
        mausacRepository.save(mauSac);
        return "redirect:/mausac/hien-thi";
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
