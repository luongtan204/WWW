package dao;

import model.ChuyenBay;

import java.util.List;

public interface ChuyenbayDAO {
    // Lấy danh sách chuyến bay
    List<ChuyenBay> getAllChuyenBay();

    // Lấy thông tin chuyến bay theo mã
    ChuyenBay getChuyenBay(String maChuyen);
}
