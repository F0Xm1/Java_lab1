package ua.lviv.iot.algo.part1.Fridge;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

public class FridgeManagerTest {

    private FridgeManager fridgeManager;
    private WineFridge wineFridge;

    @BeforeEach
    void setUp() {
        fridgeManager = new FridgeManager();
        wineFridge = new WineFridge(10, 750);
        wineFridge.numberOfBottles = "5";
    }

    @Test
    void testSearchByMaxUsableCapacity() {
        fridgeManager.addFridge(wineFridge);
        List<Fridge> fridges = fridgeManager.searchByMaxUsableCapacity(3000);
        Assertions.assertEquals(1, fridges.size());
        Assertions.assertEquals(wineFridge, fridges.get(0));
    }

    @Test
    void testSearchByClass() {
        fridgeManager.addFridge(wineFridge);
        List<Fridge> fridges = fridgeManager.searchByClass(WineFridge.class);
        Assertions.assertEquals(1, fridges.size());
        Assertions.assertEquals(wineFridge, fridges.get(0));
    }

    @Test
    void testToCSV() {
        String csv = wineFridge.toCSV("750");
        Assertions.assertEquals("5,750", csv);
    }

    @Test
    void testWriteToCSV() throws IOException {
        fridgeManager.addFridge(wineFridge);
        String filePath = "fridges.csv";
        fridgeManager.writeToCSV(filePath);
        File file = new File(filePath);
        Assertions.assertTrue(file.exists());

        // read contents of the file
        List<String> lines = Files.readAllLines(file.toPath());
        String expected = "numberOfBottles,bottleVolume\n5,750\n";
        Assertions.assertEquals(expected, String.join("\n", lines));

        // delete the file after the test
        file.delete();
    }

    @Test
    void testWriteToCSVEmptyList() throws IOException {
        String filePath = "fridges.csv";
        fridgeManager.writeToCSV(filePath);
        File file = new File(filePath);
        Assertions.assertTrue(file.exists());

        // read contents of the file
        List<String> lines = Files.readAllLines(file.toPath());
        String expected = "numberOfBottles,bottleVolume\n";
        Assertions.assertEquals(expected, String.join("\n", lines));

        // delete the file after the test
        file.delete();
    }

    @Test
    void testWriteToCSVFileExists() throws IOException {
        fridgeManager.addFridge(wineFridge);
        String filePath = "fridges.csv";

        // create a file with the same name
        File file = new File(filePath);
        file.createNewFile();

        // check that an exception is thrown when trying to write to an existing file
        Assertions.assertThrows(IOException.class, () -> {
            fridgeManager.writeToCSV(filePath);
        });

        // delete the file after the test
        file.delete();
    }
}
