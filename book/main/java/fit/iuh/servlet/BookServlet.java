package fit.iuh.servlet;



import fit.iuh.beans.Book;
import fit.iuh.dao.BookDao;
import jakarta.annotation.Resource;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import javax.sql.DataSource;
import java.io.IOException;
import java.util.List;
import java.util.logging.Logger;
@WebServlet({"/books", "/book"})
public class BookServlet extends HttpServlet {
    private BookDao bookDao;
    @Resource(name = "jdbc/bookstoredb")
    private DataSource dataSource;

    private static final Logger logger = Logger.getLogger(BookServlet.class.getName());

    @Override
    public void init() {
        bookDao = new BookDao(dataSource);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws
            ServletException, IOException {
        String idstr = req.getParameter("id");
        String q = req.getParameter("q");

        // Xử lý tìm kiếm theo id (ưu tiên nếu id là số)
        if (idstr != null && !idstr.isEmpty()) {
            try {
                int id = Integer.parseInt(idstr);
                Book book = bookDao.getProductById(id);
                if (book != null) {
                    req.setAttribute("book", book);
                    RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/book-detail.jsp");
                    dispatcher.forward(req, resp);
                    return;
                } else {
                    req.setAttribute("books", new java.util.ArrayList<Book>()); // Không tìm thấy trả về list rỗng
                    RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/book-list.jsp");
                    dispatcher.forward(req, resp);
                    return;
                }
            } catch (NumberFormatException e) {
                // Nếu id không phải số, bỏ qua và thử tìm theo tên
            }
        }
        // Xử lý tìm kiếm theo tên
        List<Book> books;
        if (q != null && !q.isEmpty()) {
            books = bookDao.searchByName(q);
        } else {
            books = bookDao.getAllProducts();
        }
        req.setAttribute("books", books);
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/book-list.jsp");
        dispatcher.forward(req, resp);
        logger.info("books: " + books);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws
            ServletException, IOException {
        //        super.doPost(req, resp);

    }
}
