package MyProg.JFX.address.model.entity.food;

import MyProg.JFX.address.model.entity.Food;

public class Apple extends Food {
    private final String name = "Яблоко";
    private final int Energy = 10;
    private final String imageURL = "file:src/resources/Chicken.png";

    public String getName() {
        return name;
    }

    public int getEnergy() {
        return Energy;
    }

    @Override
    public String toString() {
        return name;
    }

    public String getImageURL() {
        return imageURL;
    }
}
