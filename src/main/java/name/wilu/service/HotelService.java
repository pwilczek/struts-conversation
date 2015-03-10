package name.wilu.service;

import name.wilu.model.Hotel;
import name.wilu.model.Network;

public class HotelService {

    public Network readNetwork(){
        Network network = new Network();
        network.addHotel(new Hotel("Galaxy", 4));
        network.addHotel(new Hotel("Wyspianski", 22));
        return network;
    }
}
