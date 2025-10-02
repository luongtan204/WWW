package model;

public class ChuyenBay {
    private String maChuyen;
    private String tenChuyen;
    private String noiDi;
    private String noiDen;
    private java.util.Date ngayBay;

    // Constructor
    public ChuyenBay() {}

    public ChuyenBay(String maChuyen, String tenChuyen, String noiDi, String noiDen, java.util.Date ngayBay) {
        this.maChuyen = maChuyen;
        this.tenChuyen = tenChuyen;
        this.noiDi = noiDi;
        this.noiDen = noiDen;
        this.ngayBay = ngayBay;
    }

    // Getters and Setters
    public String getMaChuyen() { return maChuyen; }
    public void setMaChuyen(String maChuyen) { this.maChuyen = maChuyen; }

    public String getTenChuyen() { return tenChuyen; }
    public void setTenChuyen(String tenChuyen) { this.tenChuyen = tenChuyen; }

    public String getNoiDi() { return noiDi; }
    public void setNoiDi(String noiDi) { this.noiDi = noiDi; }

    public String getNoiDen() { return noiDen; }
    public void setNoiDen(String noiDen) { this.noiDen = noiDen; }

    public java.util.Date getNgayBay() { return ngayBay; }
    public void setNgayBay(java.util.Date ngayBay) { this.ngayBay = ngayBay; }
}