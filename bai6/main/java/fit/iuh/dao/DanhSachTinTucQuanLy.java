package fit.iuh.dao;

import fit.iuh.model.DanhMuc;
import fit.iuh.model.TinTuc;
import fit.iuh.util.DBUtil;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DanhSachTinTucQuanLy {
    private DBUtil dbUtil;
    public DanhSachTinTucQuanLy(DataSource dataSource) {
        this.dbUtil = new DBUtil(dataSource);
    }
    public TinTuc getTinTuc(String maTt) {
        TinTuc tinTuc = null;
        String sql="SELECT * FROM tintuc where MATT = ?";
        try {
            Connection con=dbUtil.getConnection();
            PreparedStatement ps=con.prepareStatement(sql);
            ps.setNString(1, maTt);
            ResultSet rs=ps.executeQuery();
            if (rs.next()) {
                //(MATT, TIEUDE, NOIDUNGTT, LIENKET, MADM)
                String maTinTuc=rs.getString("MATT");
                String maMuc=rs.getString("MADM");
                String tieude=rs.getString("TIEUDE");
                String noidungtt= rs.getString("NOIDUNGTT");
                String lienket= rs.getString("LIENKET");
                tinTuc = new TinTuc(maTinTuc, tieude, noidungtt, lienket, new DanhMuc(maMuc,null,null    ,null) );
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return tinTuc;
    }
    public List<TinTuc> getTinTucTheoDanhMuc(String maDm) {
        List<TinTuc> tinTucTheoDanhMuc = new ArrayList<>();
        String sql="SELECT * FROM tintuc where MADM = ?";
        try {
            Connection con=dbUtil.getConnection();
            PreparedStatement ps=con.prepareStatement(sql);
            ps.setNString(1, maDm);
            ResultSet rs=ps.executeQuery();
            while (rs.next()) {
                //(MATT, TIEUDE, NOIDUNGTT, LIENKET, MADM)
                String maTinTuc=rs.getString("MATT");
                String maMuc=rs.getString("MADM");
                String tieude=rs.getString("TIEUDE");
                String noidungtt= rs.getString("NOIDUNGTT");
                String lienket= rs.getString("LIENKET");
                TinTuc tinTuc = new TinTuc(maTinTuc, tieude, noidungtt, lienket, new DanhMuc(maMuc,null,null    ,null) );
                tinTucTheoDanhMuc.add(tinTuc);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return tinTucTheoDanhMuc;
    }
    public boolean addTinTuc(TinTuc tinTuc) {
        String sql = "INSERT INTO tintuc (MATT, TIEUDE, NOIDUNGTT, LIENKET, MADM) VALUES (?, ?, ?, ?, ?)";
        try {
            Connection con = dbUtil.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, tinTuc.getMaTT());
            ps.setString(2, tinTuc.getTieude());
            ps.setString(3, tinTuc.getNoidungTT());
            ps.setString(4, tinTuc.getLienket());
            ps.setString(5, tinTuc.getDanhMuc().getMaDM());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return true;
    }
    public void delete(TinTuc tinTuc) {
        String sql = "DELETE FROM tintuc WHERE MATT = ?";
        try {
            Connection con = dbUtil.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, tinTuc.getMaTT());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    // Lấy tất cả danh mục (phục vụ giao diện)
    public List<DanhMuc> getAllDanhMuc() throws SQLException {
        List<DanhMuc> ds = new ArrayList<>();
        String sql = "SELECT * FROM DANHMUC";
        try (Connection con = dbUtil.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                DanhMuc dm = new DanhMuc(
                        rs.getString("MADM"),
                        rs.getString("TENDANHMUC"),
                        rs.getString("NGUOIQUANLY"),
                        rs.getString("GHICHU")
                );
                ds.add(dm);
            }
        }
        return ds;
    }

    public List<TinTuc> getAllTinTuc() {
        List<TinTuc> ds = new ArrayList<>();
        String sql = "SELECT tt.MATT, tt.TIEUDE, tt.NOIDUNGTT, tt.LIENKET, dm.MADM, dm.TENDANHMUC, dm.GHICHU, dm.NGUOIQUANLY "
                + "FROM TINTUC tt "
                + "INNER JOIN DANHMUC dm ON tt.MADM = dm.MADM";
        try (Connection con = dbUtil.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                DanhMuc dm = new DanhMuc(
                        rs.getString("MADM"),
                        rs.getString("TENDANHMUC"),
                        rs.getString("GHICHU"),
                        rs.getString("NGUOIQUANLY")
                );
                TinTuc tt = new TinTuc(
                        rs.getString("MATT"),
                        rs.getString("TIEUDE"),
                        rs.getString("NOIDUNGTT"),
                        rs.getString("LIENKET"),
                        dm
                );
                ds.add(tt);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return ds;
    }
}
