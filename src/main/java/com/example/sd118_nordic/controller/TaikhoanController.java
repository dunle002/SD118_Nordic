package com.example.sd118_nordic.controller;

import com.example.sd118_nordic.entity.Sanpham;
import com.example.sd118_nordic.entity.Taikhoan;
import com.example.sd118_nordic.repository.SanphamRepository;
import com.example.sd118_nordic.repository.TaikhoanRepository;
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
@RequestMapping("/taikhoan/")
public class TaikhoanController {
    @Autowired
    private TaikhoanRepository taikhoanRepository;


    @GetMapping("hien-thi")
    private String getAll(@RequestParam(defaultValue = "0", name = "page") Integer number, Model model) {
        Pageable pageable = PageRequest.of(number, 5);
        Page<Taikhoan> listTaiKhoan = taikhoanRepository.findAll(pageable);
        model.addAttribute("listTaiKhoan", listTaiKhoan);
        return "taikhoan";
    }

    @GetMapping("view-update/{id}")
    public String viewUpdate(@PathVariable("id") UUID id, Model model) {
        Optional<Taikhoan> taiKhoanOptional = taikhoanRepository.findById(id);
        if (taiKhoanOptional.isPresent()) {
            Taikhoan taiKhoan = taiKhoanOptional.get();
            model.addAttribute("taiKhoan", taiKhoan);
        }
        return "updateTaikhoan";
    }


    @GetMapping("delete/{id}")
    public String delete(@PathVariable("id") String id) {
        taikhoanRepository.deleteById(UUID.fromString(id));
        return "redirect:/taikhoan/hien-thi";
    }

    @GetMapping("view-add")
    public String viewAdd(Model model) {
        List<Taikhoan> taiKhoan = taikhoanRepository.findAll();
        model.addAttribute("taiKhoan", taiKhoan);
        return "addtaikhoan";
    }

    @PostMapping("add")
    public String addTaiKhoan(@RequestParam("userName") String userName,
                              @RequestParam("password") String password,
                              @RequestParam("role") Boolean role) {
        Taikhoan taiKhoan = Taikhoan.builder()
                .userName(userName)
                .password(password)
                .role(role)
                .build();
        taikhoanRepository.save(taiKhoan);
        return "redirect:/taikhoan/hien-thi";
    }

    @PostMapping("update")
    public String updateTaikhoan(@RequestParam("id") String id,
                                 @RequestParam("userName") String userName,
                                 @RequestParam("password") String password,
                                 @RequestParam("role") String role) {
        Taikhoan taiKhoan = taikhoanRepository.findById(UUID.fromString(id))
                .orElseThrow(() -> new IllegalArgumentException("Invalid Taikhoan Id: " + id));
        taiKhoan.setUserName(userName);
        taiKhoan.setPassword(password);
        taiKhoan.setRole(Boolean.valueOf(role));
        taikhoanRepository.save(taiKhoan);

        return "redirect:/taikhoan/hien-thi";
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
