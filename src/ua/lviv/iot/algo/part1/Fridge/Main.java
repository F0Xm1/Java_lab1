package ua.lviv.iot.algo.part1.Fridge;

import lombok.ToString;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main  {
    public static void main(String[] args) {
        FridgeManager fridgeManager = new FridgeManager();

        FridgeCamera fridgeCamera1 = new FridgeCamera(2, "electric", "mechanical", 10, 5);
        FridgeCamera fridgeCamera2 = new FridgeCamera(3, "electric", "mechanical", 15, 7);
        WineFridge wineFridge1 = new WineFridge(10, 750);
        WineFridge wineFridge2 = new WineFridge(20, 1500);

        fridgeManager.addFridge(fridgeCamera1);
        fridgeManager.addFridge(fridgeCamera2);
        fridgeManager.addFridge(wineFridge1);
        fridgeManager.addFridge(wineFridge2);

        System.out.println("All fridges:");
        for (Fridge fridge : fridgeManager.fridges) {
            System.out.println(fridge.toString());
        }

        System.out.println("\nSearch by capacity >= 100:");
        for (Fridge fridge : fridgeManager.searchByMaxUsableCapacity(100)) {
            System.out.println(fridge.toString());
        }

        System.out.println("\nSearch by class WineFridge:");
        for (Fridge fridge : fridgeManager.searchByClass(WineFridge.class)) {
            System.out.println(fridge.toString());
        }
    }
}