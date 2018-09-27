import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.TimeZone;




@WebServlet(name = "Servlet_02", urlPatterns = "/flight")
public class Servlet_02 extends HttpServlet {

    private static final String DATE_FORMAT = "dd-M-yyyy hh:mm:ss a";


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String flightDepStr = request.getParameter("flightDep");
        String flightArrStr = request.getParameter("flightArr");
        String localtimeStr = request.getParameter("localtime");
        String timeStr = request.getParameter("time");
        String priceStr = request.getParameter("price");
        double price = Double.parseDouble(priceStr);
        String arrTimeZone = "";
        String depTimeZOne = "";


        if (flightArrStr.equals(flightDepStr) || localtimeStr == null || timeStr == null || price <= 0) {
            response.getWriter().println("Podano zle dane");
        } else {
            response.getWriter().println("Wylot: " + flightDepStr + " Przylot: " + flightArrStr + " Czas wylotu: " + localtimeStr + " Długość lotu: " + timeStr + " Cena: " + priceStr);
            List<Airport> list = AirportDao.getList();

            for (Airport a : list) {
                if (a.getCode().equals(flightDepStr)) {
                    arrTimeZone = a.getTimezone();
                } else if (a.getCode().equals(flightArrStr)) {
                    depTimeZOne = a.getTimezone();
                }
            }

            Flight flight = new Flight(flightDepStr, flightArrStr, price);




        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List<Airport> list = AirportDao.getList();
        request.setAttribute("list", list);

        getServletContext().getRequestDispatcher("/airForm.jsp").forward(request, response);

    }
}
