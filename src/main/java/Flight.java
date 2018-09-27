public class Flight {
    private String departure;
    private String arrival;
    private double price;

    public Flight() {
    }

    public Flight(String departure, String arrival, double price) {
        this.departure = departure;
        this.arrival = arrival;
        this.price = price;
    }

    public String getDeparture() {
        return departure;
    }

    public void setDeparture(String departure) {
        this.departure = departure;
    }

    public String getArrival() {
        return arrival;
    }

    public void setArrival(String arrival) {
        this.arrival = arrival;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
