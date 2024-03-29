package ua.lviv.iot.algo.part1.Fridge;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class WineFridgeTest {

    @Test
    public void testGetMaxUsableCapacity() {
        WineFridge fridge = new WineFridge(10, 750);
        Assertions.assertEquals(7500, fridge.getMaxUsableCapacity());
    }

    @Test
    public void testGetHeaders() {
        WineFridge fridge = new WineFridge(10, 750);
        Assertions.assertEquals("numberOfBottles,maxBottleVolume,maxBottleCount", fridge.getHeaders());
    }

    @Test
    public void testToCSV() {
        WineFridge fridge = new WineFridge(10, 750);
        String expected = "null,750,10";
        Assertions.assertEquals(expected, fridge.toCSV());
    }
}

