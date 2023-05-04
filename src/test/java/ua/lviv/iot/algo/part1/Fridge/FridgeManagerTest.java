package ua.lviv.iot.algo.part1.Fridge;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FridgeManagerTest {
    FridgeManager fridgeManager;
    FridgeCamera fridgeCamera1;
    FridgeCamera fridgeCamera2;
    WineFridge wineFridge1;
    WineFridge wineFridge2;
    @BeforeEach
    public void add() {
        fridgeManager = new FridgeManager();
        fridgeCamera1 = new FridgeCamera(2, "electric", "mechanical", 10, 5);
        fridgeCamera2 = new FridgeCamera(3, "electric", "mechanical", 15, 7);
        wineFridge1 = new WineFridge(10, 750);
        wineFridge2 = new WineFridge(20, 1500);
        fridgeManager.addFridge(fridgeCamera1);
        fridgeManager.addFridge(fridgeCamera2);
        fridgeManager.addFridge(wineFridge1);
        fridgeManager.addFridge(wineFridge2);
    }
    @Test
    void addFridge() {
        List<Fridge> expected = new ArrayList<>();
        expected.add(fridgeCamera1);
        expected.add(fridgeCamera2);
        expected.add(wineFridge1);
        expected.add(wineFridge2);
        assertEquals(expected, fridgeManager.fridges);
    }

    @Test
    void searchByMaxUsableCapacity() {
        List<Fridge> expected = new ArrayList<>();
        expected.add(wineFridge1);
        expected.add(wineFridge2);
        assertEquals(expected, fridgeManager.searchByMaxUsableCapacity(1000));
    }

    @Test
    void searchByClass() {
        List<Fridge> expected = new ArrayList<>();
        expected.add(wineFridge1);
        expected.add(wineFridge2);
        assertEquals(expected, fridgeManager.searchByClass(WineFridge.class));
    }
}
