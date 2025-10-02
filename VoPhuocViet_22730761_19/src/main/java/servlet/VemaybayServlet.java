package servlet;

import dao.VemaybayDAO;
import impl.VemaybayDAOImpl;
import jakarta.annotation.Resource;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.VeMayBay;

import javax.sql.DataSource;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

@WebServlet("/vemaybay")
public class VemaybayServlet extends HttpServlet {

    private VemaybayDAO vemaybayDAO;

    @Resource(name = "jdbc/qlvemaybay")
    private DataSource dataSource;

    @Override
    public void init() {
        vemaybayDAO = new VemaybayDAOImpl(dataSource);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) action = "list";

        switch (action) {
            case "list":
                List<VeMayBay> dsVe = vemaybayDAO.getAllVeMayBay();
                request.setAttribute("dsVeMayBay", dsVe);
                request.getRequestDispatcher("listVeMayBay.jsp").forward(request, response);
                break;
            case "byChuyenbay":
                String maChuyen = request.getParameter("maChuyen");
                List<VeMayBay> dsVeChuyen = vemaybayDAO.getVeMayBayByChuyenBay(maChuyen);
                request.setAttribute("dsVeMayBay", dsVeChuyen);
                // Để truy cập lại mã chuyến bay trong JSP (ví dụ làm Quay lại)
                request.setAttribute("maChuyen", maChuyen);
                request.getRequestDispatcher("listVeByChuyen.jsp").forward(request, response);
                break;
            case "search":
                String ten = request.getParameter("ten");
                List<VeMayBay> ketqua = vemaybayDAO.searchVeMayBayByTenHanhKhach(ten);
                request.setAttribute("dsVeMayBay", ketqua);
                request.getRequestDispatcher("searchVeMayBay.jsp").forward(request, response);
                break;
            case "edit":
                String maVe = request.getParameter("maVe");
                VeMayBay ve = vemaybayDAO.getVeMayBay(maVe);
                request.setAttribute("veMayBay", ve);
                request.getRequestDispatcher("editVeMayBay.jsp").forward(request, response);
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        if ("update".equals(action)) {
            String maVe = request.getParameter("maVe");
            String hoTen = request.getParameter("hoTenHanhKhach");
            BigDecimal giaVe = new BigDecimal(request.getParameter("giaVe"));
            String loaiVe = request.getParameter("loaiVe");
            String maChuyen = request.getParameter("maChuyen");

            VeMayBay ve = new VeMayBay(maVe, hoTen, giaVe, loaiVe, maChuyen);
            boolean ok = vemaybayDAO.updateVeMayBay(ve);

            String msg = ok ? "Cập nhật thành công!" : "Cập nhật thất bại!";

            // Quay lại trang danh sách vé của chuyến bay vừa sửa
            List<VeMayBay> dsVeChuyen = vemaybayDAO.getVeMayBayByChuyenBay(maChuyen);
            request.setAttribute("dsVeMayBay", dsVeChuyen);
            request.setAttribute("maChuyen", maChuyen);
            request.setAttribute("thongbao", msg);

            request.getRequestDispatcher("listVeByChuyen.jsp").forward(request, response);
        }
    }
}