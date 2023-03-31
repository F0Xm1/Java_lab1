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
        Fridge[] fridgeArray = {
                new Fridge(),
                new Fridge("Samsung", "RT21M63SG", 23, false, "A"),
                Fridge.getInstance(),
                Fridge.getInstance()
        };

        for (Fridge fridge : fridgeArray) {
            System.out.println(fridge);
        }
    }
}