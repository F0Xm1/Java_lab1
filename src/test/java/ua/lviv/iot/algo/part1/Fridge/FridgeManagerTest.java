package ua.lviv.iot.algo.part1.Fridge;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FridgeManagerTest {

    @Test
    void addFridge() {
        FridgeManager fridgeManager = new FridgeManager();
        Fridge fridge1 = new Fridge() {
            @Override
            int getMaxUsableCapacity() {
                return 100;
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
        };
        Fridge fridge2 = new Fridge() {
            @Override
            int getMaxUsableCapacity() {
                return 200;
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
        };
        fridgeManager.addFridge(fridge1);
        fridgeManager.addFridge(fridge2);
        List<Fridge> expected = new ArrayList<>();
        expected.add(fridge1);
        expected.add(fridge2);
        assertEquals(expected, fridgeManager.fridges);
    }

    @Test
    void searchByMaxUsableCapacity() {
        FridgeManager fridgeManager = new FridgeManager();
        Fridge fridge1 = new Fridge() {
            @Override
            int getMaxUsableCapacity() {
                return 100;
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
        };
        Fridge fridge2 = new Fridge() {
            @Override
            int getMaxUsableCapacity() {
                return 200;
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
        };
        fridgeManager.addFridge(fridge1);
        fridgeManager.addFridge(fridge2);
        List<Fridge> expected = new ArrayList<>();
        expected.add(fridge1);
        assertEquals(expected, fridgeManager.searchByMaxUsableCapacity(100));
    }

    @Test
    void searchByClass() {
        FridgeManager fridgeManager = new FridgeManager();
        Fridge fridge1 = new Fridge() {
            @Override
            int getMaxUsableCapacity() {
                return 100;
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
        };
        WineFridge wineFridge = new WineFridge(1, 2);
        fridgeManager.addFridge(fridge1);
        fridgeManager.addFridge(wineFridge);
        List<Fridge> expected = new ArrayList<>();
        expected.add(wineFridge);
        assertEquals(expected, fridgeManager.searchByClass(WineFridge.class));
    }
}
