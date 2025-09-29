package fit.iuh;

import fit.iuh.dao.BookDao;
import fit.iuh.beans.Book;
import org.mariadb.jdbc.MariaDbDataSource;

import javax.sql.DataSource;
import java.util.List;

public class BookDaoTest {
    public static void main(String[] args) throws Exception {
        MariaDbDataSource ds = new MariaDbDataSource();
        ds.setUrl("jdbc:mariadb://localhost:3306/bookstoredb");
        ds.setUser("root");
        ds.setPassword("root");

        BookDao dao = new BookDao(ds);

        // Test getAllProducts
        List<Book> books = dao.getAllProducts();
        System.out.println("Books:");
        for (Book b : books) {
            System.out.println(b.getId());
        }

    }
}
