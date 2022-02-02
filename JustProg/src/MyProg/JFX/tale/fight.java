package MyProg.JFX.tale;

import MyProg.JFX.address.model.entity.Player;
import MyProg.JFX.address.model.entity.Monsters;
import MyProg.JFX.address.view.ChapterOneController;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;



public class fight {
    private ImageView mainScene;
    private TextArea textOfTale;
    private ChapterOneController ch;
    private Player player;
    private Monsters enemy;
    private final String pngMainScene = "file:src/resources/battle.jpg";

    boolean perk = true;

    public void start (Player player, Monsters enemy){
        mainScene.setImage(new Image(pngMainScene));
        this.player = player;
        this.enemy = enemy;
        ch.setHandlePoint(10);
        textOfTale.setText("**Бой**\n" +
                String.format("Вы-\"%s\": Здоровье - %s, Атака - %s, Защита - %s\n",
                        player.getHero().getName(), player.getHero().getHealth(),
                        player.getHero().getStrength(), player.getHero().getDefence()) +
                String.format("Противник-\"%s\": Здоровье - %s, Атака - %s, Защита - %s\n",
                        enemy.getName(), enemy.getHealth(), enemy.getStrength(), enemy.getDefence()) +
                "**Бой**"
        );
        ch.buttonNext.setText("Далее...");
    }

    public void playersTurn(){
        if (player.getHero().getHealth() == 0){
            textOfTale.setText("***\n" +
                    "Поражение!\n" +
                    "***");
        } else {
            ch.setHandlePoint(11);
            textOfTale.setText(String.format("Вы-\"%s\": Здоровье - %s, Атака - %s, Защита - %s\n",
                    player.getHero().getName(), player.getHero().getHealth(),
                    player.getHero().getStrength(), player.getHero().getDefence()) +
                    String.format("Противник-\"%s\": Здоровье - %s\n", enemy.getName(), enemy.getHealth()));
            ch.buttonOne.setText("Атака");
            ch.buttonTwo.setText("Способность");
            ch.buttonThree.setText("Ничего");
        }
    }

    public void enemyTurn() {
        ch.setHandlePoint(10);
        if (enemy.getHealth() == 0) {
             textOfTale.setText("***\n" +
                    "Победа!\n" +
                    "***");
             //todo Сценарий
        } else {
            ch.setHandlePoint(20);
            textOfTale.setText(String.format("Ходит %s", enemy.getName()));
            ch.buttonNext.setText("Далее...");
        }
    }

    public void setMainScene(ImageView mainScene) {
        this.mainScene = mainScene;
    }

    public void setTextOfTale(TextArea textOfTale) {
        this.textOfTale = textOfTale;
    }

    public void setCh(ChapterOneController ch) {
        this.ch = ch;
    }
}
