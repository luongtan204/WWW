package fit.iuh.servlet;

import fit.iuh.dao.DanhSachTinTucQuanLy;
import fit.iuh.model.DanhMuc;
import fit.iuh.model.TinTuc;

import jakarta.annotation.Resource;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import javax.sql.DataSource;
import java.io.IOException;
import java.util.List;

@WebServlet({"/danhsachtintuc","/dsa"})
public class DanhSachTinTucServlet extends HttpServlet {

    @Resource(name = "jdbc/quanlydanhmuc")
    private DataSource dataSource;

    private DanhSachTinTucQuanLy dao;

    @Override
    public void init() throws ServletException {
        dao = new DanhSachTinTucQuanLy(dataSource);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null) action = "list";
        try {
            switch (action) {
                case "new":
                    // Hiển thị form thêm tin tức mới
                    List<DanhMuc> danhMucsNew = dao.getAllDanhMuc();
                    req.setAttribute("danhMucs", danhMucsNew);
                    req.getRequestDispatcher("TinTucForm.jsp").forward(req, resp);
                    break;
                case "list":
                default:
                    // Hiển thị danh sách tin tức theo từng danh mục
                    String maDM = req.getParameter("maDM");
                    List<DanhMuc> danhMucs = dao.getAllDanhMuc();
                    req.setAttribute("danhMucs", danhMucs);

                    List<TinTuc> tinTucs;
                    if (maDM != null && !maDM.isEmpty()) {
                        tinTucs = dao.getTinTucTheoDanhMuc(maDM);
                        req.setAttribute("selectedMaDM", maDM);
                    } else {
                        if (!danhMucs.isEmpty()) {
                            maDM = danhMucs.get(0).getMaDM();
                            tinTucs = dao.getTinTucTheoDanhMuc(maDM);
                            req.setAttribute("selectedMaDM", maDM);
                        } else {
                            tinTucs = null;
                        }
                    }
                    req.setAttribute("tinTucs", tinTucs);
                    req.getRequestDispatcher("DanhSachTinTuc.jsp").forward(req, resp);
                    break;
            }
        } catch (Exception ex) {
            throw new ServletException(ex);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null) action = "add";
        try {
            switch (action) {
                case "add":
                default:
                    // Lấy dữ liệu từ form (đã kiểm tra hợp lệ phía client)
                    String maTT = req.getParameter("maTT");
                    String tieude = req.getParameter("tieude");
                    String noidungTT = req.getParameter("noidungTT");
                    String lienket = req.getParameter("lienket");
                    String maDM = req.getParameter("maDM");

                    // Tìm danh mục
                    DanhMuc dm = null;
                    for (DanhMuc d : dao.getAllDanhMuc()) {
                        if (d.getMaDM().equals(maDM)) {
                            dm = d;
                            break;
                        }
                    }
                    // Thêm tin tức vào CSDL
                    TinTuc tt = new TinTuc(maTT, tieude, noidungTT, lienket, dm);
                    boolean ok = dao.addTinTuc(tt);

                    if (ok) {
                        // Nếu thêm thành công, chuyển sang KetQua.jsp để hiển thị thông tin vừa thêm
                        req.setAttribute("tinTuc", tt);
                        req.getRequestDispatcher("KetQua.jsp").forward(req, resp);


                        // resp.sendRedirect("danhsachtintuc?maDM=" + maDM);
                    } else {
                        req.setAttribute("message", "Thêm tin tức thất bại!");
                        List<DanhMuc> danhMucs = dao.getAllDanhMuc();
                        req.setAttribute("danhMucs", danhMucs);
                        req.getRequestDispatcher("TinTucForm.jsp").forward(req, resp);
                    }
                    break;
            }
        } catch (Exception e) {
            throw new ServletException(e);
        }
    }
   }