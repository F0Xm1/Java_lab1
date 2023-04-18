package ua.lviv.iot.algo.part1.Fridge;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class FridgeManager extends Fridge {
    List<Fridge> fridges = new ArrayList<>();

    public void addFridge(Fridge fridge) {
        fridges.add(fridge);
    }

    public List<Fridge> searchByMaxUsableCapacity(int capacity) {
        return fridges.stream().filter(f -> f.getMaxUsableCapacity() >= capacity).collect(Collectors.toList());
    }

    public List<Fridge> searchByClass(Class<? extends Fridge> fridgeClass) {
        return fridges.stream().filter(f -> f.getClass().equals(fridgeClass)).collect(Collectors.toList());
    }

    @Override
    int getMaxUsableCapacity() {
        return 0;
    }

    @Override
    public String getHeaders() {
        return null;
    }

    @Override
    public String toCSV(String bottleVolume) {
        return null;
    }

    @Override
    public void writeToCSV(String filePath) {

    }
}

