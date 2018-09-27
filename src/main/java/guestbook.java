import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "guest-book", urlPatterns = "/guest-book")
public class guestbook extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String description = request.getParameter("description");

        try {
            Connection connection = setConnection();
            String sql = "INSERT INTO guest (name, description) VALUES (?, ?)";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, name);
            ps.setString(2, description);
            ps.executeUpdate();
            ps.close();
            connection.close();
            response.getWriter().println("Dodano wpis");
        } catch (SQLException e) {
            e.printStackTrace();

        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            Connection connection = setConnection();
            String sql = "SELECT * FROM guest ORDER BY id desc";
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet resultSet = ps.executeQuery();

            List<Entry> book = new ArrayList<>();
            while (resultSet.next()) {
                String name = resultSet.getString("name");
                String description = resultSet.getString("description");
                Entry entry = new Entry(name, description);
                book.add(entry);
            }
            ps.close();
            connection.close();
            request.setAttribute("book", book);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        getServletContext().getRequestDispatcher("/guest-book.jsp").forward(request, response);
    }

    public Connection setConnection() throws SQLException {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Db Driver Loaded");
            Connection connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/library?useSSL=false" +
                            "&characterEncoding=utf8" +
                            "&useUnicode=true" +
                            "&useJDBCCompliantTimezoneShift=true" +
                            "&useLegacyDatetimeCode=false" +
                            "&serverTimezone=UTC",
                    "root", "coderslab");
            return connection;

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("ERROR: failed loading Db Driver");
        }
        return null;
    }
}

