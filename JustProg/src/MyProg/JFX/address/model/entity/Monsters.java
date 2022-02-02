package MyProg.JFX.address.model.entity;

import MyProg.JFX.address.view.ChapterOneController;

public class Monsters {
    private String name;
    private int health;
    private int strength;
    private int defence;
    ChapterOneController ch;

    public void attack(Hero enemy) {
    }

    public void death() {
        health = 0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
