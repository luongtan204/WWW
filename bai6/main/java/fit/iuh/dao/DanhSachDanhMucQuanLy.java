package fit.iuh.dao;

import fit.iuh.util.DBUtil;

import javax.sql.DataSource;

public class DanhSachDanhMucQuanLy {
    private DBUtil dbUtil;

    public DanhSachDanhMucQuanLy(DataSource dataSource) {
        this.dbUtil = new DBUtil(dataSource);
    }

}
