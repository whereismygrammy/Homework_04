import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "Servlet_01_1", urlPatterns = "/Servlet_01_1")
public class Servlet_01_1 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

        if (session.isNew()) {
            getServletContext().getRequestDispatcher("/zadanie4_1.jsp").forward(request, response);
        } else {

            Cookie[] cookies = request.getCookies();
            String welcomeMessage = "Cześć";
            for (Cookie cok : cookies) {
                if (cok.getName().equals("lang")) {
                    String chosenLanguage = cok.getValue();
                    Map<String, String> langMap = getLangMap();
                    welcomeMessage = langMap.get(chosenLanguage);
                }
            }
            response.getWriter().println(welcomeMessage);
        }
    }

    protected Map<String, String> getLangMap() {
        Map<String, String> lang = new HashMap<>();
        lang.put("en", "Hello");
        lang.put("pl", "Cześć");
        lang.put("de", "Ehre");
        lang.put("es", "Hola");
        lang.put("fr", "Bienvenue");
        return lang;
    }

}
