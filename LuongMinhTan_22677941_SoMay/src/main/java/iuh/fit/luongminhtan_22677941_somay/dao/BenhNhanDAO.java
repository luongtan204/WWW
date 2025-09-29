package iuh.fit.luongminhtan_22677941_somay.dao;

import iuh.fit.luongminhtan_22677941_somay.model.BenhNhan;
import iuh.fit.luongminhtan_22677941_somay.util.DBUtil;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class BenhNhanDAO {
    private DBUtil dbutil;

    public BenhNhanDAO(DataSource dataSource) {
        dbutil = new DBUtil(dataSource);
    }

    // Xem danh sách bệnh nhân
    public List<BenhNhan> getAllBenhNhan() {
        List<BenhNhan> list = new ArrayList<>();
        String sql = "SELECT * FROM BENHNHAN";

        try (Connection conn = dbutil.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                BenhNhan bn = new BenhNhan();
                bn.setMaBN(rs.getInt("MABN"));
                bn.setHoTen(rs.getString("HOTEN"));
                bn.setNgayNhapVien(rs.getDate("NGAYNHAPVIEN"));
                bn.setChuanDoan(rs.getString("CHUANDOAN"));
                bn.setMaKhoa(rs.getInt("MAKHOA"));
                list.add(bn);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    // Tìm kiếm bệnh nhân theo tên (LIKE)
    public List<BenhNhan> searchByName(String keyword) {
        List<BenhNhan> list = new ArrayList<>();
        String sql = "SELECT * FROM BENHNHAN WHERE HOTEN LIKE ?";

        try (Connection conn = dbutil.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, "%" + keyword + "%");
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    BenhNhan bn = new BenhNhan();
                    bn.setMaBN(rs.getInt("MABN"));
                    bn.setHoTen(rs.getString("HOTEN"));
                    bn.setNgayNhapVien(rs.getDate("NGAYNHAPVIEN"));
                    bn.setChuanDoan(rs.getString("CHUANDOAN"));
                    bn.setMaKhoa(rs.getInt("MAKHOA"));
                    list.add(bn);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    // Xem danh sách bệnh nhân theo khoa điều trị
    public List<BenhNhan> getByKhoa(int maKhoa) {
        List<BenhNhan> list = new ArrayList<>();
        String sql = "SELECT * FROM BENHNHAN WHERE MAKHOA=?";

        try (Connection conn = dbutil.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, maKhoa);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    BenhNhan bn = new BenhNhan();
                    bn.setMaBN(rs.getInt("MABN"));
                    bn.setHoTen(rs.getString("HOTEN"));
                    bn.setNgayNhapVien(rs.getDate("NGAYNHAPVIEN"));
                    bn.setChuanDoan(rs.getString("CHUANDOAN"));
                    bn.setMaKhoa(rs.getInt("MAKHOA"));
                    list.add(bn);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    // Thêm mới bệnh nhân theo khoa điều trị
    public void save(BenhNhan bn) {
        String sql = "INSERT INTO BENHNHAN(HOTEN, NGAYNHAPVIEN, CHUANDOAN, MAKHOA) VALUES (?,?,?,?)";
        try (Connection conn = dbutil.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, bn.getHoTen());
            ps.setDate(2, bn.getNgayNhapVien());
            ps.setString(3, bn.getChuanDoan());
            ps.setInt(4, bn.getMaKhoa());
            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
