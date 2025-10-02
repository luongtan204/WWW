package dao;

import model.VeMayBay;

import java.math.BigDecimal;
import java.util.List;

public interface VemaybayDAO {
    // Lấy danh sách vé máy bay
    List<VeMayBay> getAllVeMayBay();

    // Lấy vé máy bay theo mã vé
    VeMayBay getVeMayBay(String maVe);

    // Lấy danh sách vé theo chuyến bay
    List<VeMayBay> getVeMayBayByChuyenBay(String maChuyen);

    // Tìm kiếm vé máy bay theo tên hành khách (gần đúng)
    List<VeMayBay> searchVeMayBayByTenHanhKhach(String tenHanhKhach);

    // Chỉnh sửa thông tin vé máy bay theo chuyến bay (ví dụ: cập nhật loại vé và giá vé cho tất cả vé thuộc một chuyến)
    int updateVeMayBayByChuyenBay(String maChuyen, String loaiVeMoi, BigDecimal giaVeMoi);

    // Chỉnh sửa thông tin vé máy bay theo mã vé
    boolean updateVeMayBay(VeMayBay ve);
}
