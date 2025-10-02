package servlet;

import dao.ChuyenbayDAO;
import impl.ChuyenbayDAOImpl;
import jakarta.annotation.Resource;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.ChuyenBay;

import javax.sql.DataSource;
import java.io.IOException;
import java.util.List;

@WebServlet("/chuyenbay")
public class ChuyenbayServlet extends HttpServlet {

    private ChuyenbayDAO chuyenbayDAO;

    @Resource(name = "jdbc/qlvemaybay")
    private DataSource dataSource;

    @Override
    public void init() {
        chuyenbayDAO = new ChuyenbayDAOImpl(dataSource);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) action = "list";

        switch (action) {
            case "list":
                List<ChuyenBay> dsChuyenBay = chuyenbayDAO.getAllChuyenBay();
                request.setAttribute("dsChuyenBay", dsChuyenBay);
                request.getRequestDispatcher("listChuyenBay.jsp").forward(request, response);
                break;
            case "detail":
                String maChuyen = request.getParameter("maChuyen");
                ChuyenBay cb = chuyenbayDAO.getChuyenBay(maChuyen);
                request.setAttribute("chuyenBay", cb);
                request.getRequestDispatcher("chitietChuyenBay.jsp").forward(request, response);
                break;
        }
    }
}