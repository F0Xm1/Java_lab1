package ua.lviv.iot.algo.part1.Fridge;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class FridgeWriter {
    public void writeToFile(List<Fridge> fridges, String filename) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(filename));
            for (Fridge fridge : fridges) {
                writer.write(fridge.getHeaders());
                writer.newLine();
                writer.write(fridge.toCSV());
                writer.newLine();
            }
            writer.close();
        } catch (IOException e) {
            System.err.println("Error writing to file " + filename + ": " + e.getMessage());
        }
    }
}