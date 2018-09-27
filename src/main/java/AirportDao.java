import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class AirportDao {

    public static List<Airport> getList() {
        Path path = Paths.get("/home/tom/workspace/Homework_04/src/airports.txt");
        List<Airport> airportList = new ArrayList<>();

        try {

            List<String> list = Files.readAllLines(path);

            for (String s : list) {
                Airport airport = new Airport();
                String[] split = s.split(";");
                airport.setName(split[0]);
                airport.setCode(split[1]);
                airport.setTimezone(split[2]);
                airportList.add(airport);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }


        return airportList;
    }
}
