package com.thuvien.thuvien.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "nhap_sach_chi_tiet")
public class NhapSachChiTiet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int soLuong = 0;
    private double thanhTien = 0;
    private String ghiChu = "";

    @ManyToOne
    @JoinColumn(name = "sach_id", nullable = false)
    private Sach sach;

    public NhapSachChiTiet() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public double getThanhTien() {
        return thanhTien;
    }

    public void setThanhTien(double thanhTien) {
        this.thanhTien = thanhTien;
    }

    public Sach getSach() {
        return sach;
    }

    public void setSach(Sach sach) {
        this.sach = sach;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }
}
