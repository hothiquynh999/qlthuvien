package com.thuvien.thuvien.service;

import com.thuvien.thuvien.model.NhaCungCap;
import com.thuvien.thuvien.model.Sach;
import com.thuvien.thuvien.model.TheLoaiSach;
import com.thuvien.thuvien.repository.NhaCungCapRepository;
import com.thuvien.thuvien.repository.TheLoaiSachRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class NhaCungCapService {
    @Autowired
    private NhaCungCapRepository nhaCungCapRepository;

    public List<NhaCungCap> findAll() {
        return nhaCungCapRepository.findAll();
    }

    public void save(NhaCungCap nhaCungCap) {
        nhaCungCapRepository.save(nhaCungCap);
    }

    public void deleteById(Long id) {
        nhaCungCapRepository.deleteById(id);
    }

    public NhaCungCap findById(Long id) {
        return nhaCungCapRepository.findById(id).orElseThrow(()->new IllegalArgumentException("k có nhà cung cấp"));
    }

    public int tongNhaCC() {
        List<NhaCungCap> dichVus = findAll();
        Integer tong=dichVus.size();
        return  tong;
    }

    public List<NhaCungCap> index(String search) {
        List<NhaCungCap> saches = new ArrayList<>();
        if(search.equals("")){
            saches = findAll();
        }else {
            saches = nhaCungCapRepository.findByTenContaining(search);
        }
        return saches;
    }
}
