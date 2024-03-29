package ua.lviv.iot.algo.part1.Fridge;

public class Main  {
    private static String numberOfBottles;
    private static String bottleVolume;

    public static void main(String[] args) {
        FridgeManager fridgeManager = new FridgeManager();
        Freezer freezer = new Freezer();
        freezer.method1();
        freezer.method2();

        fridgeManager = new FridgeManager();
        FridgeCamera fridgeCamera1 = new FridgeCamera(2, "electric", "mechanical", 10, 5);
        FridgeCamera fridgeCamera2 = new FridgeCamera(3, "electric", "mechanical", 15, 7);
        WineFridge wineFridge1 = new WineFridge(10, 750);
        WineFridge wineFridge2 = new WineFridge(20, 1500);
        fridgeManager.addFridge(fridgeCamera1);
        fridgeManager.addFridge(fridgeCamera2);
        fridgeManager.addFridge(wineFridge1);
        fridgeManager.addFridge(wineFridge2);
        System.out.println("Всі холодильники:");
        for (Fridge fridge : fridgeManager.fridges) {
            System.out.println(fridge.toString());
        }

        System.out.println("\nПошук по об'єму >= 100:");
        for (Fridge fridge : fridgeManager.searchByMaxUsableCapacity(100)) {
            System.out.println(fridge.toString());
        }

        System.out.println("\nПошук за класом WineFridge:");
        for (Fridge fridge : fridgeManager.searchByClass(WineFridge.class)) {
            System.out.println(fridge.toString());
        }

        FridgeWriter fridgeWriter = new FridgeWriter();
        fridgeWriter.writeToFile(fridgeManager.fridges, "fridges.csv");
    }
}



