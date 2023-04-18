package ua.lviv.iot.algo.part1.Fridge;

class Freezer extends Fridge {
    public int getTemperature() {
        return -20;
    }

    public void method1() {
        System.out.println("Freezer Максимальна температура: -15 градусів");
    }

    public void method2() {
        System.out.println("Freezer Мінімальна температура: -2 градуси");
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

