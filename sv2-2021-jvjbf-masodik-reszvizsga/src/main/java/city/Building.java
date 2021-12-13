package city;

public abstract class Building {
    private double area;
    private int levels;
    private Address address;

    public Building(double area, int levels, Address address) {
        this.area = area;
        this.levels = levels;
        this.address = address;
    }

    public Building(double area, Address address) {
        this(area, 1, address);
    }

    public abstract int calculateNumberOfPeopleCanFit();

    public double getFullArea() {
        return area * levels;
    }

    public double getArea() {
        return area;
    }

    public int getLevels() {
        return levels;
    }

    public Address getAddress() {
        return address;
    }
}
