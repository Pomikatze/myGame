package MyProg.JFX.address.model.entity;

import MyProg.JFX.address.view.ChapterOneController;

public abstract class Hero {
    private String name;
    private int health;
    private int strength;
    private int defence;
    private ChapterOneController ch;

    public abstract void attack (Monsters enemy);

    public abstract void eat (Food item);

    public abstract void death ();

    public abstract  void perk (Monsters enemy);

    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getDefence() {
        return defence;
    }

    public void setDefence(int defence) {
        this.defence = defence;
    }

    public void setCh(ChapterOneController ch) {
        this.ch = ch;
    }
}
