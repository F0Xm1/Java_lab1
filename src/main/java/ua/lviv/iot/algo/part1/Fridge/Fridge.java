package ua.lviv.iot.algo.part1.Fridge;


import java.util.List;

public abstract class Fridge {
    abstract int getMaxUsableCapacity();
    public abstract String getHeaders();
    public abstract String toCSV();

    public  List<Fridge> getFridges() {
        return null;
    }

    public abstract void writeToCSV(String filePath);

    public void setNumberOfBottles(int i) {
    }
}