package iuh.fit.luongminhtan_22677941_somay.model;

import java.sql.Date;

public class BenhNhan {
    private int maBN;
    private String hoTen;
    private Date ngayNhapVien;
    private String chuanDoan;
    private int maKhoa; // foreign key tới Khoa

    public BenhNhan() {
    }

    public BenhNhan(int maBN, String hoTen, Date ngayNhapVien, String chuanDoan, int maKhoa) {
        this.maBN = maBN;
        this.hoTen = hoTen;
        this.ngayNhapVien = ngayNhapVien;
        this.chuanDoan = chuanDoan;
        this.maKhoa = maKhoa;
    }

    public int getMaBN() {
        return maBN;
    }

    public void setMaBN(int maBN) {
        this.maBN = maBN;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public Date getNgayNhapVien() {
        return ngayNhapVien;
    }

    public void setNgayNhapVien(Date ngayNhapVien) {
        this.ngayNhapVien = ngayNhapVien;
    }

    public String getChuanDoan() {
        return chuanDoan;
    }

    public void setChuanDoan(String chuanDoan) {
        this.chuanDoan = chuanDoan;
    }

    public int getMaKhoa() {
        return maKhoa;
    }

    public void setMaKhoa(int maKhoa) {
        this.maKhoa = maKhoa;
    }
}
