package name.wilu.model;

import java.util.ArrayList;
import java.util.List;

public class Network {

    private List<Hotel> hotels = new ArrayList();

    public List<Hotel> getHotels() {
        return hotels;
    }

    public void addHotel(Hotel hotel) {
        hotels.add(hotel);
    }
}
