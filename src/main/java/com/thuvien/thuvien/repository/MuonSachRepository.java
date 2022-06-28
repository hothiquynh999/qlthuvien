package com.thuvien.thuvien.repository;

import com.thuvien.thuvien.model.MuonSach;
import com.thuvien.thuvien.model.TheLoaiSach;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MuonSachRepository extends JpaRepository<MuonSach, Long> {

 List<MuonSach> findByKhachHangTenContainingAndStatus(String search, Byte status);
 List<MuonSach> findByStatus(Byte status);

    @Query("SELECT cms FROM MuonSach cms \n" +
            "WHERE YEAR(cms.ngayMuon) = 2022 AND MONTH(cms.ngayMuon) = ?1 AND cms.status = 1")
     List<MuonSach> doanhThuNam(int i);

    List<MuonSach> findByKhachHangDienThoaiContainingAndStatus(String search, byte b);
}
