package ua.lviv.iot.algo.part1.Fridge;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class FridgeWriterTest {
    private List<Fridge> fridges;
    private FridgeWriter fridgeWriter;
    private WineFridge wineFridge;
    String filename = "fridges.csv";
    File file;
    @BeforeEach
    void setUp() {
        file = new File(filename);
        fridges = new ArrayList<>();
        fridgeWriter = new FridgeWriter();
        FridgeCamera fridgeCamera1 = new FridgeCamera(2, "electric", "mechanical", 10, 5);
        FridgeCamera fridgeCamera2 = new FridgeCamera(3, "electric", "mechanical", 15, 7);
        WineFridge wineFridge1 = new WineFridge(10, 750);
        WineFridge wineFridge2 = new WineFridge(20, 1500);
        fridges.add(fridgeCamera1);
        fridges.add(fridgeCamera2);
        fridges.add(wineFridge1);
        fridges.add(wineFridge2);
    }

    @Test
    void testWriteToFile() throws IOException {
        fridgeWriter.writeToFile(fridges, filename);
        Assertions.assertTrue(file.exists());
        Scanner expect = new Scanner(new FileReader("line.csv"));
        StringBuilder line = new StringBuilder();
        while (expect.hasNext()) {
            line.append(expect.next());
        }
        expect.close();
        Scanner scanner = new Scanner(new FileReader(file));
        StringBuilder content = new StringBuilder();
        while (scanner.hasNext()) {
            content.append(scanner.next());
        }
        scanner.close();

        Assertions.assertEquals(line.toString(), content.toString());
    }
}