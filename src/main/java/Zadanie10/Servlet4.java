package Zadanie10;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "Servlet4", urlPatterns = "/history")
public class Servlet4 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String parameter = request.getParameter("his");
        if ("true".equals(parameter)) {
            HttpSession session = request.getSession();
            session.removeAttribute("history");
            response.getWriter().println("Usunięto historię");
        } else {
            getServletContext().getRequestDispatcher("/Zadanie10.jsp").forward(request, response);
        }

    }
}
