package iuh.fit.luongminhtan_22677941_somay.servlet;

import iuh.fit.luongminhtan_22677941_somay.dao.KhoaDAO;
import iuh.fit.luongminhtan_22677941_somay.model.Khoa;
import jakarta.annotation.Resource;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import javax.sql.DataSource;
import java.io.IOException;
import java.util.List;

@WebServlet("/khoa")
public class KhoaServlet extends HttpServlet {

    @Resource(name = "jdbc/QLBenhNhan")
    private DataSource dataSource;

    private KhoaDAO khoaDao;

    @Override
    public void init(ServletConfig config) throws ServletException {
        try {
            khoaDao = new KhoaDAO(dataSource);
        } catch (Exception e) {
            throw new ServletException(e);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        // chỉ có 1 chức năng: xem danh sách khoa
        List<Khoa> listKhoa = khoaDao.getAllKhoa();
        req.setAttribute("khoas", listKhoa);
        req.getRequestDispatcher("khoa-list.jsp").forward(req, resp);
    }
}
