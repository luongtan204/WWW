package fit.iuh.servlet;

import fit.iuh.dao.DanhSachTinTucQuanLy;
import fit.iuh.model.TinTuc;

import jakarta.annotation.Resource;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import javax.sql.DataSource;
import java.io.IOException;
import java.util.List;

@WebServlet("/quanlytintuc")
public class QuanLyFormServlet extends HttpServlet {

    @Resource(name = "jdbc/quanlydanhmuc")
    private DataSource dataSource;

    private DanhSachTinTucQuanLy dao;

    @Override
    public void init() throws ServletException {
        dao = new DanhSachTinTucQuanLy(dataSource);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Hiển thị danh sách tin tức để quản lý (xóa)
        try {
            List<TinTuc> tinTucs = dao.getAllTinTuc();
            req.setAttribute("tinTucs", tinTucs);
            req.getRequestDispatcher("QuanLyForm.jsp").forward(req, resp);
        } catch (Exception ex) {
            throw new ServletException(ex);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Xử lý xóa tin tức
        String maTT = req.getParameter("maTT");
        TinTuc tt= dao.getTinTuc(maTT);
        if (maTT != null && !maTT.isEmpty()) {
            try {
                dao.delete(tt);
            } catch (Exception ex) {
                throw new ServletException(ex);
            }
        }
        // Sau khi xóa, load lại danh sách
        resp.sendRedirect("quanlytintuc");
    }
}