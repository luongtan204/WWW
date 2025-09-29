package fit.iuh.servlet;

import fit.iuh.beans.CartBean;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/checkout")
public class CheckoutServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        CartBean cart = (CartBean) session.getAttribute("cart");
        if (cart == null) {
            cart = new CartBean();
            session.setAttribute("cart", cart);
        }
        req.setAttribute("cart", cart);
        RequestDispatcher dispatcher = req.getRequestDispatcher("/thanhtoan.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String fullname = req.getParameter("fullname");
        String address = req.getParameter("address");
        String payment = req.getParameter("payment");
        HttpSession session = req.getSession();
        CartBean cart = (CartBean) session.getAttribute("cart");
        double total = (cart != null) ? cart.getTao() : 0;

        // Here you would save the order to the database, send email, etc.
        // For demo, just clear the cart and show a success message
        if (cart != null) {
            cart.clear();
        }
        req.setAttribute("message", "Order placed successfully! Thank you, " + fullname + ".");
        req.setAttribute("total", total);
        RequestDispatcher dispatcher = req.getRequestDispatcher("/checkout-success.jsp");
        dispatcher.forward(req, resp);
    }
}

