package MyProg.JFX.address.model.entity.monsters;

import MyProg.JFX.address.model.entity.Hero;
import MyProg.JFX.address.model.entity.Monsters;
import MyProg.JFX.address.view.ChapterOneController;

public class Golem extends Monsters {
    private ChapterOneController ch;
    private final String name = "Голем";
    private int health = 75;
    private final int strength = 55;
    private final int defence = 15;

    @Override
    public void attack(Hero hero) {
        int damage = strength - hero.getDefence();
        hero.setHealth(hero.getHealth() - damage);
        ch.notify(String.format("%s нанёс %s урона по %s", name, damage, hero.getName()));
        ch.setHealthNumber(hero.getHealth());
        ch.setHealth((double) hero.getHealth());
        if (hero.getHealth() <= 0){
            hero.death();
            ch.notify(String.format("%n умер", hero.getName()));
        }
    }

    @Override
    public void death() {
        health = 0;
    }

    public String getName() {
        return name;
    }

    @Override
    public int getHealth() {
        return health;
    }

    @Override
    public void setHealth(int health) {
        this.health = health;
    }

    @Override
    public int getStrength() {
        return strength;
    }

    @Override
    public int getDefence() {
        return defence;
    }

    public void setCh(ChapterOneController ch) {
        this.ch = ch;
    }
}
