package ua.lviv.iot.algo.part1.Fridge;

import lombok.ToString;

@ToString
public class WineFridge extends Fridge {
    private final int maxBottleCount;
    private final int maxBottleVolume;
    public String numberOfBottles;

    public WineFridge(int maxBottleCount, int maxBottleVolume) {
        this.maxBottleCount = maxBottleCount;
        this.maxBottleVolume = maxBottleVolume;
    }
    public String getHeaders() {
        return "numberOfBottles,bottleVolume";
    }

    public String toCSV(String bottleVolume) {
        return numberOfBottles + "," + bottleVolume;
    }

    @Override
    public void writeToCSV(String filePath) {

    }

    @Override
    int getMaxUsableCapacity() {
        return maxBottleCount * maxBottleVolume;
    }

    public String toCSV() {
        return null;
    }
}