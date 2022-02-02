package MyProg.JFX.address.model.entity.heroes;

import MyProg.JFX.address.model.entity.Food;
import MyProg.JFX.address.model.entity.Hero;
import MyProg.JFX.address.model.entity.Monsters;
import MyProg.JFX.address.view.ChapterOneController;

public class Wizard extends Hero {
    private String name;
    private int health = 100;
    private int strength = 20;
    private int defence = 15;
    private ChapterOneController ch;

    @Override
    public void attack(Monsters enemy) {
        int damage = strength - enemy.getDefence();
        enemy.setHealth(enemy.getHealth() - damage);
        ch.notify(String.format("%s нанёс %s урона по %s", name, damage, enemy.getName()));
        if (enemy.getHealth() <= 0){
            enemy.death();
            ch.notify(String.format("%s умер", enemy.getName()));
        }
    }

    @Override
    public void eat(Food food) {
        health = health + food.getEnergy();
        ch.notify(String.format("Вы восстановили %s здоровья", food.getEnergy()));
        if (health >= 100) health = 100;
        ch.setHealthNumber(health);
        ch.setHealth((double) health);
    }

    @Override
    public void death() {
        health = 0;
        ch.notify(name + " DIED");
        ch.setHealthNumber(health);
        ch.setHealth((double) health);
    }

    public Wizard(String name) {
        this.name = name;
    }

    @Override
    public void perk(Monsters enemy) {
        health = health + 25;
        if (health >= 100) health = 100;
        ch.notify("Вы восстановили 25 здоровья");
        ch.setHealthNumber(health);
        ch.setHealth((double) health);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
    public void setStrength(int strength) {
        this.strength = strength;
    }

    @Override
    public int getDefence() {
        return defence;
    }

    @Override
    public void setDefence(int defence) {
        this.defence = defence;
    }

    public void setCh(ChapterOneController ch) {
        this.ch = ch;
    }
}
