package ua.lviv.iot.algo.part1.Fridge;

import lombok.ToString;

@ToString
public class WineFridge extends Fridge {
    private final int maxBottleCount;
    private final int maxBottleVolume;

    public WineFridge(int maxBottleCount, int maxBottleVolume) {
        this.maxBottleCount = maxBottleCount;
        this.maxBottleVolume = maxBottleVolume;
    }

    @Override
    int getMaxUsableCapacity() {
        return maxBottleCount * maxBottleVolume;
    }
}
