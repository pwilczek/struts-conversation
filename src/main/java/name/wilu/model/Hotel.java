package name.wilu.model;

public class Hotel {

    private final String name;
    private final int capacity;

    public Hotel(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
    }

    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }
}
