package ua.lviv.iot.algo.part1.Fridge;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class FridgeWriter extends Fridge {
    public void writeToFile(List<Fridge> fridges, String filename, String bottleVolume) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(filename));
            for (Fridge fridge : fridges) {
                writer.write(fridge.getHeaders());
                writer.newLine();
                writer.write(fridge.toCSV(bottleVolume));
                writer.newLine();
            }
            writer.close();
        } catch (IOException e) {
            System.err.println("Error writing to file " + filename + ": " + e.getMessage());
        }
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

    public void writeToFile(List<Fridge> fridges, String s, String numberOfBottles, String bottleVolume) {

    }
}