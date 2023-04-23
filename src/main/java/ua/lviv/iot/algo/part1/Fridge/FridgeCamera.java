package ua.lviv.iot.algo.part1.Fridge;

import lombok.ToString;

@ToString
public class FridgeCamera extends Fridge {
    private final int numberOfEntries;
    private final String tapeDriveType;
    private final String sausageMovementType;
    private final int tapeSpeed;
    private final int maxSausageWeight;

    public static final int VOLUME_PER_KILOGRAM = 10;

    public FridgeCamera(int numberOfEntries, String tapeDriveType, String sausageMovementType, int tapeSpeed, int maxSausageWeight) {
        this.numberOfEntries = numberOfEntries;
        this.tapeDriveType = tapeDriveType;
        this.sausageMovementType = sausageMovementType;
        this.tapeSpeed = tapeSpeed;
        this.maxSausageWeight = maxSausageWeight;
    }

    @Override
    int getMaxUsableCapacity() {
        return maxSausageWeight * VOLUME_PER_KILOGRAM;
    }

    @Override
    public String getHeaders() {
        return "numberOfEntries,tapeDriveType,sausageMovementType,tapeSpeed,maxSausageWeight";
    }

    @Override
    public String toCSV() {
        return numberOfEntries + "," + tapeDriveType + "," + sausageMovementType + "," + tapeSpeed + "," + maxSausageWeight;
    }

    @Override
    public void writeToCSV(String filePath) {

    }
}