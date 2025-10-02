package impl;

import model.VeMayBay;
import util.util.DBUtil;

import javax.sql.DataSource;
import java.sql.*;
import java.util.*;
import java.math.BigDecimal;

public class VemaybayDAOImpl implements dao.VemaybayDAO {
    private DBUtil dbUtil;

    public VemaybayDAOImpl(DataSource dataSource) {
        this.dbUtil = new DBUtil(dataSource);
    }

    // Lấy danh sách vé máy bay
    @Override
    public List<VeMayBay> getAllVeMayBay() {
        List<VeMayBay> list = new ArrayList<>();
        String sql = "SELECT * FROM vemaybay";
        try (
            Connection con = dbUtil.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery()
        ) {
            while (rs.next()) {
                VeMayBay ve = new VeMayBay(
                    rs.getString("MAVE"),
                    rs.getString("HOTENHANHKHACH"),
                    rs.getBigDecimal("GIAVE"),
                    rs.getString("LOAIVE"),
                    rs.getString("MACHUYEN")
                );
                list.add(ve);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;
    }

    // Lấy vé máy bay theo mã vé
    @Override
    public VeMayBay getVeMayBay(String maVe) {
        VeMayBay ve = null;
        String sql = "SELECT * FROM vemaybay WHERE MAVE = ?";
        try (
            Connection con = dbUtil.getConnection();
            PreparedStatement ps = con.prepareStatement(sql)
        ) {
            ps.setString(1, maVe);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    ve = new VeMayBay(
                        rs.getString("MAVE"),
                        rs.getString("HOTENHANHKHACH"),
                        rs.getBigDecimal("GIAVE"),
                        rs.getString("LOAIVE"),
                        rs.getString("MACHUYEN")
                    );
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return ve;
    }

    // Lấy danh sách vé theo chuyến bay
    @Override
    public List<VeMayBay> getVeMayBayByChuyenBay(String maChuyen) {
        List<VeMayBay> list = new ArrayList<>();
        String sql = "SELECT * FROM vemaybay WHERE MACHUYEN = ?";
        try (
            Connection con = dbUtil.getConnection();
            PreparedStatement ps = con.prepareStatement(sql)
        ) {
            ps.setString(1, maChuyen);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    VeMayBay ve = new VeMayBay(
                        rs.getString("MAVE"),
                        rs.getString("HOTENHANHKHACH"),
                        rs.getBigDecimal("GIAVE"),
                        rs.getString("LOAIVE"),
                        rs.getString("MACHUYEN")
                    );
                    list.add(ve);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;
    }

    // Tìm kiếm vé máy bay theo tên hành khách (gần đúng)
    @Override
    public List<VeMayBay> searchVeMayBayByTenHanhKhach(String tenHanhKhach) {
        List<VeMayBay> list = new ArrayList<>();
        String sql = "SELECT * FROM vemaybay WHERE HOTENHANHKHACH LIKE ?";
        try (
            Connection con = dbUtil.getConnection();
            PreparedStatement ps = con.prepareStatement(sql)
        ) {
            ps.setString(1, "%" + tenHanhKhach + "%");
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    VeMayBay ve = new VeMayBay(
                        rs.getString("MAVE"),
                        rs.getString("HOTENHANHKHACH"),
                        rs.getBigDecimal("GIAVE"),
                        rs.getString("LOAIVE"),
                        rs.getString("MACHUYEN")
                    );
                    list.add(ve);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;
    }

    // Chỉnh sửa thông tin vé máy bay theo chuyến bay (ví dụ: cập nhật loại vé và giá vé cho tất cả vé thuộc một chuyến)
    @Override
    public int updateVeMayBayByChuyenBay(String maChuyen, String loaiVeMoi, BigDecimal giaVeMoi) {
        String sql = "UPDATE vemaybay SET LOAIVE=?, GIAVE=? WHERE MACHUYEN=?";
        try (
            Connection con = dbUtil.getConnection();
            PreparedStatement ps = con.prepareStatement(sql)
        ) {
            ps.setString(1, loaiVeMoi);
            ps.setBigDecimal(2, giaVeMoi);
            ps.setString(3, maChuyen);
            return ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    // Chỉnh sửa thông tin vé máy bay theo mã vé
    @Override
    public boolean updateVeMayBay(VeMayBay ve) {
        String sql = "UPDATE vemaybay SET HOTENHANHKHACH=?, GIAVE=?, LOAIVE=?, MACHUYEN=? WHERE MAVE=?";
        try (
            Connection con = dbUtil.getConnection();
            PreparedStatement ps = con.prepareStatement(sql)
        ) {
            ps.setString(1, ve.getHoTenHanhKhach());
            ps.setBigDecimal(2, ve.getGiaVe());
            ps.setString(3, ve.getLoaiVe());
            ps.setString(4, ve.getMaChuyen());
            ps.setString(5, ve.getMaVe());
            int rows = ps.executeUpdate();
            return rows > 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}