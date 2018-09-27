import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "Servlet_01_2", urlPatterns = "/Servlet_01_2")
public class Servlet_01_2 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String lang = request.getParameter("lang");

        Cookie cookie = new Cookie("lang", lang);
        cookie.setPath("/");
        cookie.setMaxAge(3600);
        response.addCookie(cookie);


        response.getWriter().println("Udało się ustawić ciasteczko");


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


    }
}
