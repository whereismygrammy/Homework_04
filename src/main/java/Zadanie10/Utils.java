package Zadanie10;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

public class Utils {

    public static void historyMaker(HttpServletRequest request, HttpServletResponse response, String siteInfo) {
        HttpSession session = request.getSession();
        List<String> history;
        Object historyFromSession = session.getAttribute("history");

        if (historyFromSession == null) {
            history = new ArrayList<>();
        } else {
            history = (ArrayList<String>) historyFromSession;
        }
        history.add(siteInfo);
        session.setAttribute("history", history);
    }

}
