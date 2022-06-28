package com.thuvien.thuvien.controller;

import com.thuvien.thuvien.model.NhaCungCap;
import com.thuvien.thuvien.model.Sach;
import com.thuvien.thuvien.service.NhaCungCapService;
import com.thuvien.thuvien.service.TheLoaiSachService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@CrossOrigin
@RequestMapping("nha-cung-cap")
public class NhaCungCapController {
    @Autowired
    private NhaCungCapService nhaCungCapService;

    @GetMapping("")
    public String index(Model model,@RequestParam(name = "search", required = false, defaultValue = "") String search){
        model.addAttribute("DanhSach", nhaCungCapService.index(search));
        model.addAttribute("search", search);
        return "NhaCungCap/danh_sach";
    }

    @GetMapping("/them")
    public String add(Model model){
        model.addAttribute("NhaCungCap", new NhaCungCap());
        model.addAttribute("TheLoai", nhaCungCapService.findAll());
        return "NhaCungCap/add";
    }

    @PostMapping("/save")
    public String add_post(@ModelAttribute NhaCungCap nhaCungCap){
        nhaCungCapService.save(nhaCungCap);
        return "redirect:/nha-cung-cap";
    }

    @GetMapping("/sua/{id}")
    public String sua(Model model,@PathVariable Long id){
         model.addAttribute("NhaCungCap", nhaCungCapService.findById(id));
         return "NhaCungCap/add";
    }

    @GetMapping("/xoa/{id}")
    public String xoa(Model model,@PathVariable Long id){
        nhaCungCapService.deleteById(id);
        return "redirect:/nha-cung-cap";
    }
}
