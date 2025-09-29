package iuh.fit.luongminhtan_22677941_somay.servlet;

import iuh.fit.luongminhtan_22677941_somay.dao.BenhNhanDAO;
import iuh.fit.luongminhtan_22677941_somay.dao.KhoaDAO;
import iuh.fit.luongminhtan_22677941_somay.model.BenhNhan;
import jakarta.annotation.Resource;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import javax.sql.DataSource;
import java.io.IOException;
import java.sql.Date;
import java.util.List;

@WebServlet("/benhnhan")
public class BenhNhanServlet extends HttpServlet {

    @Resource(name = "jdbc/QLBenhNhan")
    private DataSource dataSource;

    private BenhNhanDAO benhNhanDao;
    private KhoaDAO khoaDao;

    @Override
    public void init(ServletConfig config) throws ServletException {
        try {
            benhNhanDao = new BenhNhanDAO(dataSource);
            khoaDao = new KhoaDAO(dataSource);
        } catch (Exception e) {
            throw new ServletException(e);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String action = req.getParameter("action");
        if (action == null) action = "list";

        switch (action) {
            case "list": // xem danh sách bệnh nhân
                List<BenhNhan> listBN = benhNhanDao.getAllBenhNhan();
                req.setAttribute("benhnhans", listBN);
                req.getRequestDispatcher("benhnhan-list.jsp").forward(req, resp);
                break;

            case "search": // tìm kiếm bệnh nhân theo tên
                String keyword = req.getParameter("keyword");
                List<BenhNhan> searchResult = benhNhanDao.searchByName(keyword);
                req.setAttribute("benhnhans", searchResult);
                req.getRequestDispatcher("benhnhan-list.jsp").forward(req, resp);
                break;

            case "byKhoa": // xem bệnh nhân theo khoa
                int maKhoa = Integer.parseInt(req.getParameter("makhoa"));
                List<BenhNhan> bnByKhoa = benhNhanDao.getByKhoa(maKhoa);
                req.setAttribute("benhnhans", bnByKhoa);
                req.setAttribute("khoa", khoaDao.getById(maKhoa));
                req.getRequestDispatcher("benhnhan-list.jsp").forward(req, resp);
                break;

            case "new": // form thêm bệnh nhân
                req.setAttribute("khoas", khoaDao.getAllKhoa());
                req.getRequestDispatcher("benhnhan-form.jsp").forward(req, resp);
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        // thêm mới bệnh nhân theo khoa
        String hoTen = req.getParameter("hoten");
        Date ngayNhapVien = Date.valueOf(req.getParameter("ngaynhapvien"));
        String chuanDoan = req.getParameter("chuandoan");
        int maKhoa = Integer.parseInt(req.getParameter("makhoa"));

        BenhNhan bn = new BenhNhan(0, hoTen, ngayNhapVien, chuanDoan, maKhoa);
        benhNhanDao.save(bn);

        resp.sendRedirect("benhnhan?action=list");
    }
}
