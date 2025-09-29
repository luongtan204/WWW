package fit.iuh.dao;

import fit.iuh.beans.Book;
import fit.iuh.util.DBUtil;
import jakarta.annotation.Resource;
import org.mariadb.jdbc.MariaDbDataSource;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BookDao {
    private DBUtil dbUtil;

    public BookDao(DataSource dataSource) {
        dbUtil = new DBUtil(dataSource);
    }

    public List<Book> getAllProducts() {
        List<Book> list = new ArrayList<>();
        String sql = "SELECT * FROM products";
        try (Connection conn = dbUtil.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Integer id = rs.getInt("ProductID");
                String title = rs.getString("ProductName");
                double price = rs.getDouble("Price");
                int quantity = rs.getInt("Quantity");
                String image = rs.getString("IMGURL");
                Book b = new Book(id, title, quantity, price, image);
                list.add(b);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
    public Book getProductById(int id) {
        String sql = "SELECT * FROM products WHERE ProductID=?";
        try (Connection conn = dbUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    String model = rs.getString("ProductName");
                    double price = rs.getDouble("Price");
                    int quantity = rs.getInt("Quantity");
                    String image = rs.getString("IMGURL");
                    Book p = new Book(id, model, quantity, price, image);
                    return p;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    public List<Book> searchByName(String name) {
        List<Book> list = new ArrayList<>();
        String sql = "SELECT * FROM products WHERE ProductName LIKE ?";
        try (Connection conn = dbUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, "%" + name + "%");
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Integer id = rs.getInt("ProductID");
                    String title = rs.getString("ProductName");
                    double price = rs.getDouble("Price");
                    int quantity = rs.getInt("Quantity");
                    String image = rs.getString("IMGURL");
                    Book b = new Book(id, title, quantity, price, image);
                    list.add(b);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }



}