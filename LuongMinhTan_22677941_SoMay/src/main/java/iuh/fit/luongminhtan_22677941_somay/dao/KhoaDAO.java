package iuh.fit.luongminhtan_22677941_somay.dao;

import iuh.fit.luongminhtan_22677941_somay.model.Khoa;
import iuh.fit.luongminhtan_22677941_somay.util.DBUtil;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class KhoaDAO {
    private DBUtil dbutil;

    public KhoaDAO(DataSource dataSource) {
        dbutil = new DBUtil(dataSource);
    }

    // Xem danh sách khoa
    public List<Khoa> getAllKhoa() {
        List<Khoa> list = new ArrayList<>();
        String sql = "SELECT * FROM KHOA";

        try (Connection conn = dbutil.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Khoa k = new Khoa();
                k.setMaKhoa(rs.getInt("MAKHOA"));
                k.setTenKhoa(rs.getString("TENKHOA"));
                k.setTruongKhoa(rs.getString("TRUONGKHOA"));
                k.setMoTa(rs.getString("MOTA"));
                list.add(k);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    // Lấy thông tin khoa theo id (phục vụ khi thêm bệnh nhân)
    public Khoa getById(int maKhoa) {
        Khoa k = null;
        String sql = "SELECT * FROM KHOA WHERE MAKHOA=?";
        try (Connection conn = dbutil.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, maKhoa);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    k = new Khoa();
                    k.setMaKhoa(rs.getInt("MAKHOA"));
                    k.setTenKhoa(rs.getString("TENKHOA"));
                    k.setTruongKhoa(rs.getString("TRUONGKHOA"));
                    k.setMoTa(rs.getString("MOTA"));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return k;
    }
}
