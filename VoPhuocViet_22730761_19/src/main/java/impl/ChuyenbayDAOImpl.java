package impl;

import model.ChuyenBay;
import util.util.DBUtil;

import javax.sql.DataSource;
import java.sql.*;
import java.sql.Date;
import java.util.*;

public class ChuyenbayDAOImpl implements dao.ChuyenbayDAO {
    private DBUtil dbUtil;

    public ChuyenbayDAOImpl(DataSource dataSource) {
        this.dbUtil = new DBUtil(dataSource);
    }

    // Lấy danh sách chuyến bay
    @Override
    public List<ChuyenBay> getAllChuyenBay() {
        List<ChuyenBay> list = new ArrayList<>();
        String sql = "SELECT * FROM chuyenbay";
        try (
            Connection con = dbUtil.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery()
        ) {
            while (rs.next()) {
                String maChuyen = rs.getString("MACHUYEN");
                String tenChuyen = rs.getString("TENCHUYEN");
                String noiDi = rs.getString("NOIDI");
                String noiDen = rs.getString("NOIDEN");
                Date ngayBay = rs.getDate("NGAYBAY");
                ChuyenBay cb = new ChuyenBay(maChuyen, tenChuyen, noiDi, noiDen, ngayBay);
                list.add(cb);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;
    }

    // Lấy thông tin chuyến bay theo mã
    @Override
    public ChuyenBay getChuyenBay(String maChuyen) {
        ChuyenBay chuyenBay = null;
        String sql = "SELECT * FROM chuyenbay WHERE MACHUYEN = ?";
        try (
            Connection con = dbUtil.getConnection();
            PreparedStatement ps = con.prepareStatement(sql)
        ) {
            ps.setString(1, maChuyen);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    String tenChuyen = rs.getString("TENCHUYEN");
                    String noiDi = rs.getString("NOIDI");
                    String noiDen = rs.getString("NOIDEN");
                    Date ngayBay = rs.getDate("NGAYBAY");
                    chuyenBay = new ChuyenBay(maChuyen, tenChuyen, noiDi, noiDen, ngayBay);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return chuyenBay;
    }
}