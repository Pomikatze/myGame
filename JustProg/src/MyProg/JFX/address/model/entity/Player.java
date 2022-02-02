package MyProg.JFX.address.model.entity;

import java.util.List;

public class Player {
    Hero hero;
    List<Food> bag;

    public Hero getHero() {
        return hero;
    }

    public void setHero(Hero hero) {
        this.hero = hero;
    }

    public List<Food> getBag() {
        return bag;
    }

    public void setBag(List<Food> bag) {
        this.bag = bag;
    }
}
