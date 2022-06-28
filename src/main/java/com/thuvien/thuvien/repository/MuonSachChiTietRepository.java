package com.thuvien.thuvien.repository;

import com.thuvien.thuvien.model.MuonSach;
import com.thuvien.thuvien.model.MuonSachChiTiet;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MuonSachChiTietRepository extends JpaRepository<MuonSachChiTiet, Long> {

    List<MuonSachChiTiet> findByMuonSachId(Long id);
}
