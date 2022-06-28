package com.thuvien.thuvien.controller;

import com.thuvien.thuvien.model.NhaCungCap;
import com.thuvien.thuvien.model.NhapSach;
import com.thuvien.thuvien.service.NhaCungCapService;
import com.thuvien.thuvien.service.NhapSachService;
import com.thuvien.thuvien.service.SachService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@CrossOrigin
@RequestMapping("nhap-sach")
public class NhapSachController {
    @Autowired
    private SachService sachService;
    @Autowired
    private NhaCungCapService nhaCungCapService;
    @Autowired
    private NhapSachService nhapSachService;


    @RequestMapping("")
    public String index(Model model){
        model.addAttribute("DanhSach", nhapSachService.findAll());
        model.addAttribute("Sach", sachService.findAll());
        model.addAttribute("NhaCC", nhaCungCapService.findAll());
        return "NhapSach/nhap-sach";
    }

    @PostMapping("/edit/{id}")
    public ResponseEntity<NhapSach> edit(@PathVariable Long id, @RequestBody NhapSach nhapSach){
        return new ResponseEntity<>(nhapSachService.edit(id,nhapSach), HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<NhapSach> add(@RequestBody NhapSach nhapSach){
        return new ResponseEntity<>(nhapSachService.add(nhapSach), HttpStatus.OK);
    }

    @RequestMapping("/xoa/{id}")
    public String xoa(@PathVariable Long id){
        nhapSachService.deleteById(id);
        return "redirect:/nhap-sach";
    }
}
