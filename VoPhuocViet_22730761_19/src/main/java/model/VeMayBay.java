package model;

import java.math.BigDecimal;

public class VeMayBay {
    private String maVe;
    private String hoTenHanhKhach;
    private BigDecimal giaVe;
    private String loaiVe;
    private String maChuyen; // Khóa ngoại, lưu mã chuyến bay

    // Constructor
    public VeMayBay() {}

    public VeMayBay(String maVe, String hoTenHanhKhach, BigDecimal giaVe, String loaiVe, String maChuyen) {
        this.maVe = maVe;
        this.hoTenHanhKhach = hoTenHanhKhach;
        this.giaVe = giaVe;
        this.loaiVe = loaiVe;
        this.maChuyen = maChuyen;
    }

    // Getters and Setters
    public String getMaVe() { return maVe; }
    public void setMaVe(String maVe) { this.maVe = maVe; }

    public String getHoTenHanhKhach() { return hoTenHanhKhach; }
    public void setHoTenHanhKhach(String hoTenHanhKhach) { this.hoTenHanhKhach = hoTenHanhKhach; }

    public BigDecimal getGiaVe() { return giaVe; }
    public void setGiaVe(BigDecimal giaVe) { this.giaVe = giaVe; }

    public String getLoaiVe() { return loaiVe; }
    public void setLoaiVe(String loaiVe) { this.loaiVe = loaiVe; }

    public String getMaChuyen() { return maChuyen; }
    public void setMaChuyen(String maChuyen) { this.maChuyen = maChuyen; }
}