package ua.lviv.iot.algo.part1.Fridge;

import lombok.*;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Fridge {
    private String brand;
    private String model;
    private int capacity;
    private boolean isDefrosting;
    private String energyEfficiencyClass;
    private static Fridge instance = new Fridge();
    public static Fridge getInstance() {
        return instance;
    }

    public void turnOnDefrosting() {
        this.isDefrosting = true;
    }

    public void turnOffDefrosting() {

        this.isDefrosting = false;
    }


    public void deleteModelInfo() {
        this.model = null;
    }
    public static void main(String[] args) {
        Fridge[] FridgeArray = new Fridge[4];
        FridgeArray[0] = new Fridge();
        FridgeArray[1] = new Fridge ("Samsung", "RT21M63SG", 23, false, "A");
        FridgeArray[2] = Fridge.getInstance();
        FridgeArray[3] = Fridge.getInstance();
            System.out.println(FridgeArray[1] );
    }
}
