package city;

import java.util.ArrayList;
import java.util.List;

public class City {
    private String name;
    private long fullArea;
    private List<Building> buildings = new ArrayList<>();

    public City(String name, long fullArea) {
        this.name = name;
        this.fullArea = fullArea;
    }

    public void addBuilding(Building building) {
        if (fullArea >= (building.getArea() + getSumBuildingsArea())) {
            buildings.add(building);
        }
        else {
            throw new IllegalArgumentException("City can't be larger than " + fullArea);
        }
    }

    public Building findHighestBuilding() {
        List<Building> highestBuildings = new ArrayList<>();
        int maxLevel = 0;
        for (Building actual : buildings) {
            if (actual.getLevels() > maxLevel) {
                maxLevel = actual.getLevels();
                highestBuildings.clear();
            }
            if (actual.getLevels() == maxLevel) {
                highestBuildings.add(actual);
            }
        }
        return highestBuildings.get(0);
    }

    public List<Building> findBuildingsByStreet(String street) {
        List<Building> results = new ArrayList<>();
        for (Building actual : buildings) {
            if (actual.getAddress().getStreet().equals(street)) {
                results.add(actual);
            }
        }
        return results;
    }

    public boolean isThereBuildingWithMorePeopleThan(int numberOfPeople) {
        for (Building actual : buildings) {
            if (actual.calculateNumberOfPeopleCanFit() >= numberOfPeople) {
                return true;
            }
        }
        return false;
    }

    public String getName() {
        return name;
    }

    public long getFullArea() {
        return fullArea;
    }

    public List<Building> getBuildings() {
        return new ArrayList<>(buildings);
    }

    private long getSumBuildingsArea() {
        long sum = 0;
        for (Building actual : buildings) {
            sum += actual.getArea();
        }
        return sum;
    }
}
