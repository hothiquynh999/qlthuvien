package com.thuvien.thuvien.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "nhap_sach")
public class NhapSach {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Temporal(TemporalType.TIMESTAMP)
    private Date ngayNhap;

    private int soLuong;
    private double tongTien;


    @ManyToOne
    @JoinColumn(name = "sach_id", nullable = false)
    private Sach sach;

    @ManyToOne
    @JoinColumn(name = "nhaCungCap_id", nullable = false)
    private NhaCungCap nhaCungCap;

    public NhapSach() {
    }

    public NhapSach(int soLuong, double tongTien, Sach sach) {
        this.soLuong = soLuong;
        this.tongTien = tongTien;
        this.sach = sach;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getNgayNhap() {
        return ngayNhap;
    }

    public void setNgayNhap(Date ngayNhap) {
        this.ngayNhap = ngayNhap;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public double getTongTien() {
        return tongTien;
    }

    public void setTongTien(double tongTien) {
        this.tongTien = tongTien;
    }

    public void setSach(Sach sach) {
        this.sach = sach;
    }

    public Sach getSach() {
        return sach;
    }

    public NhaCungCap getNhaCungCap() {
        return nhaCungCap;
    }

    public void setNhaCungCap(NhaCungCap nhaCungCap) {
        this.nhaCungCap = nhaCungCap;
    }
}
