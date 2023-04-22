package ua.lviv.iot.algo.part1.Fridge;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

class FridgeWriterTest {
    private List<Fridge> fridges;
    private FridgeWriter fridgeWriter;
    private WineFridge wineFridge;

    @BeforeEach
    void setUp() {
        fridges = new ArrayList<>();
        fridgeWriter = new FridgeWriter();
        wineFridge = new WineFridge(10, 750);
        wineFridge.setNumberOfBottles(5);
        fridges.add(wineFridge);
    }

    @Test
    void testWriteToFile() throws IOException {
        String filename = "fridges.csv";
        fridgeWriter.writeToFile(fridges, filename, "750");

        File file = new File(filename);
        Assertions.assertTrue(file.exists());

        BufferedReader br = new BufferedReader(new FileReader(file));
        String headerLine = br.readLine();
        String contentLine = br.readLine();
        br.close();

        Assertions.assertEquals("numberOfBottles,bottleVolume", headerLine);
        Assertions.assertEquals("5,750", contentLine);

        file.delete();
    }

    @Test
    void testWriteToFileIOException() {
        String filename = "\\/:*?\"<>|/fridges.csv";
        Assertions.assertThrows(IOException.class, () -> {
            fridgeWriter.writeToFile(fridges, filename, "750");
        });
    }

}