import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@WebServlet(name = "newsletter", urlPatterns = "/newsletter")
public class newsletter extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String name = request.getParameter("name");

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

            String sql = "INSERT INTO newsletter (name, email) VALUES ( ?, ?)";

            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, name);
            ps.setString(2, email);
            ps.executeUpdate();
            ps.close();

            response.getWriter().println("Zapisano do bazy " + email + " " + name);


        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("ERROR: failed loading Db Driver");
        }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        boolean showForm = true;
        Cookie[] cookies = request.getCookies();

        if (cookies != null) {
            for (Cookie c : cookies) {
                if (c.getName().equals("24h")) {
                    showForm = false;
                }
            }
        }

        if (showForm) {
            Cookie cookie = new Cookie("24h", "dontShow");
            cookie.setMaxAge(86400);
            response.addCookie(cookie);
            getServletContext().getRequestDispatcher("/newsletter.jsp").forward(request, response);
        }


    }
}
