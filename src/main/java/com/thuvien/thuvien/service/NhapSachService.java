package com.thuvien.thuvien.service;


import com.thuvien.thuvien.model.NhapSach;
import com.thuvien.thuvien.model.Sach;
import com.thuvien.thuvien.repository.NhapSachRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;


@Service
public class NhapSachService {
    @Autowired
    private NhapSachRepository nhapSachRepository;
    @Autowired
    private SachService sachService;


    public void save(NhapSach nhapSach) {
        nhapSachRepository.save(nhapSach);
    }


    public List<NhapSach> findAll() {
        return nhapSachRepository.findAll();
    }

    public NhapSach findById(Long id) {
        return nhapSachRepository.findById(id).orElseThrow(()->new IllegalArgumentException("Không có id loại sách"));
    }



    public NhapSach edit(Long id, NhapSach nhapSach) {
        NhapSach nhapSach1 = findById(id);
        nhapSach.setId(id);

        int soLuongNew = nhapSach.getSoLuong();
        int soLuongCu = nhapSach1.getSoLuong();

        Sach sach = sachService.findById(nhapSach.getSach().getId());
        int soLuongSach = sach.getSoLuong();
        sach.setSoLuong(soLuongSach - soLuongCu + soLuongNew);
        sachService.save(sach);

        nhapSachRepository.save(nhapSach);

        return nhapSach;
    }

    public NhapSach add(NhapSach nhapSach) {
        Sach sach = sachService.findById(nhapSach.getSach().getId());
        sach.setSoLuong(sach.getSoLuong()+ nhapSach.getSoLuong());
        sachService.save(sach);

        LocalDateTime localDateTime = LocalDateTime.now();
        Date ngayNhap = Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());

        nhapSach.setNgayNhap(ngayNhap);

        save(nhapSach);
        return nhapSach;
    }

    public void deleteById(Long id) {
        NhapSach nhapSach = findById(id);
        nhapSach.getSoLuong();

        Sach sach = sachService.findById(nhapSach.getSach().getId());
        sach.setSoLuong(sach.getSoLuong()- nhapSach.getSoLuong());
        sachService.save(sach);

        nhapSachRepository.deleteById(id);
    }

}
