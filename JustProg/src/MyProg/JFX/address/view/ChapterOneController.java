package MyProg.JFX.address.view;

import MyProg.JFX.address.MainApp;
import MyProg.JFX.address.model.entity.Player;
import MyProg.JFX.address.model.entity.food.Chicken;
import MyProg.JFX.address.model.entity.heroes.Paladin;
import MyProg.JFX.address.model.entity.heroes.War;
import MyProg.JFX.address.model.entity.heroes.Wizard;
import MyProg.JFX.address.model.entity.monsters.Troll;
import MyProg.JFX.tale.fight;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class ChapterOneController {
    @FXML
    private CheckBox music;
    @FXML
    private TextArea textOfTale;
    @FXML
    private ImageView imageOfBagOne;
    @FXML
    private ImageView imageOfBagTwo;
    @FXML
    private ImageView imageOfBagThree;
    @FXML
    private ImageView imageOfBagFour;
    @FXML
    private ImageView imageOfBagFive;
    @FXML
    private ImageView imageOfBagSix;
    @FXML
    private ImageView playerIcon;
    @FXML
    private Label playerName;
    @FXML
    private Label notifyTextOne;
    @FXML
    private Label notifyTextTwo;
    @FXML
    private Label notifyTextThree;
    @FXML
    private ImageView mainScene;
    @FXML
    public Label buttonOne;
    @FXML
    public Label buttonTwo;
    @FXML
    public Label buttonThree;
    @FXML
    private ProgressBar health;
    @FXML
    public Label buttonNext;
    @FXML
    private Label healthNumber;

    MainApp mainApp;
    Stage dialogStage;
    MediaPlayer mediaPlayer;
    Player player;
    private int handlePoint = 0;
    private int perk = 1;
    Troll troll = new Troll();
    fight fight = new fight();
    private final String pngPaladin = "file:src/resources/Paladin.png";
    private final String pngWar = "file:src/resources/Warrior.png";
    private final String pngPriest = "file:src/resources/priest.png";

    public ChapterOneController() {
    }

    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
    }

    public void setMediaPlayer(MediaPlayer mediaPlayer){
        this.mediaPlayer = mediaPlayer;
        if (mediaPlayer.getStatus() == MediaPlayer.Status.PAUSED){
            music.setSelected(true);
        }
    }

    public void setDialogStage (Stage dialogStage){
        this.dialogStage = dialogStage;
    }

    public void start (Player player){
        this.player = player;
        player.getHero().setCh(this);
        troll.setCh(this);
        playerName.setText(player.getHero().getName());
        if (player.getHero().getClass().equals(War.class)){
            playerIcon.setImage(new Image(pngWar));
        } else if (player.getHero().getClass().equals(Paladin.class)){
            playerIcon.setImage(new Image(pngPaladin));
        } else if (player.getHero().getClass().equals(Wizard.class)){
            playerIcon.setImage(new Image(pngPriest));
        }
        textOfTale.setText("Вы просыпаетесь на полу в таверне. Голова раскалывается. На полу валяется\n" +
                "мебель, чья-то оборваная одежда.\n" +
                "Вы: - Фух ну и гулянка вчера была! Боги! Как же болит голова. А где все?");
        buttonOne.setText("Осмотреться");
        buttonTwo.setText("Осмотреть себя");
        handlePoint = 1;
    }

    private void var_1 (){
        handlePoint = 2;
        textOfTale.setText(
                "Вы осматриваетесь по сторонам. На столах стоят недопитые бокалы, где-то\n" +
                        "картина упала со стены, одно окно выбито.\n" +
                        "Вы: - Что тут произошло? Не похоже на обычную пьянку.\n" +
                        "На барной стойке вы замечаете жирную золотистую жареную курицу.\n" +
                        "Наверное очень вкусно..."
        );
        buttonOne.setText("Взять курицу");
        buttonTwo.setText("Оставить");
    }

    private void var_2 (){
        handlePoint = 3;
        player.getBag().add(new Chicken());
        imageOfBagOne.setImage(new Image("file:src/resources/Chicken.png"));
        notifyTextOne.setText("Получено Курица");
        textOfTale.setText(
                "С улицы раздались женские крики. Что это? надо пойти посмотреть.\n" +
                        "Вы выхоидте на улицу и видите, как люди разбегаются от троля!\n" +
                        "Вы: - Троль?! От куда он тут? Эй, крысья морда, а ну не тронь\n" +
                        "эту красавицу!\n" +
                        "Троль увидел вас и, недолго думая, с воплями побежал в вашу сторону\n" +
                        "размахивая дубиной..."
        );
        buttonNext.setText("Далее...");
    }

    private void var_3 (){
        handlePoint = 3;
        textOfTale.setText(
                "Вы осматриваете себя. Одежда грязная, на руках царапины. Кошелёк... Эй, а\n" +
                        "где кошелёк? Вы выбегаете на улицу в надежде найти воришку, но\n" +
                        " перед вами предстаёт необычная картина: Троли напали на вашу деревню.\n" +
                        "Жители в страхе разбегаются перед ними. Вы заприметили одного.\n" +
                        "Вы: - Троль?! От куда он тут? Эй, крысья морда, а ну не тронь эту красавицу!\n" +
                        "Троль увидел вас и, недолго думая, с воплями побежал в вашу сторону размахивая\n" +
                        "дубиной..."
        );
        buttonNext.setText("Далее...");
    }

    @FXML
    private void handleMusic(){
        if (music.isSelected()){
            mainApp.musicOff();
        } else mainApp.musicOn();
    }

    @FXML
    private void handleButtonOne(){
        if (handlePoint == 1){
            isButtonNull();
            var_1();
        } else if (handlePoint == 2){
            isButtonNull();
            var_2();
        } else if (handlePoint == 11){
            isButtonNull();
            player.getHero().attack(troll);
            perk = 1;
            fight.enemyTurn();
        }
    }

    @FXML
    private void handleButtonTwo(){
        if (handlePoint == 1){
            isButtonNull();
            var_3();
        } else if (handlePoint == 2){
            isButtonNull();
            var_2();
        } else if (handlePoint == 11 && perk == 1){
            isButtonNull();
            perk = 0;
            player.getHero().perk(troll);
            fight.enemyTurn();
        } else if (handlePoint == 11 && perk == 0){
            notify("Способность ещё не готова!");
        }
    }

    @FXML
    private void handleButtonThree(){
        if (handlePoint == 11){
            isButtonNull();
            perk = 1;
            fight.enemyTurn();
        }
    }

    @FXML
    private void handleNext(){
        if (handlePoint == 3){
            isButtonNull();
            fight.setMainScene(mainScene);
            fight.setTextOfTale(textOfTale);
            fight.setCh(this);
            fight.start(player, troll);
        } else if (handlePoint == 10){
            isButtonNull();
            fight.playersTurn();
        } else if (handlePoint == 20){
            isButtonNull();
            troll.attack(player.getHero());
            fight.playersTurn();
        }
    }

    @FXML
    private void handleExit(){
        dialogStage.close();
        mainApp.closeApp();
    }

    @FXML
    private void handleBagOne(){
        if (player.getBag().size() > 0){
            eat(0);
        }
    }

    @FXML
    private void handleBagTwo(){
        if (player.getBag().size() > 1){
            eat(1);
        }
    }

    @FXML
    private void handleBagThree(){
        if (player.getBag().size() > 2){
            eat(2);
        }
    }

    @FXML
    private void handleBagFour(){
        if (player.getBag().size() > 3){
            eat(3);
        }
    }

    @FXML
    private void handleBagFive(){
        if (player.getBag().size() > 4){
            eat(4);
        }
    }

    @FXML
    private void handleBagSix(){
        if (player.getBag().size() > 5){
            eat(5);
        }
    }

    @FXML
    private void handlePersonIcon(){
        mainApp.showPersonDetails(player);
    }

    @FXML
    private void mouseOnButtonOne(){
        buttonOne.setTextFill(Color.web("#ff0000"));
    }

    @FXML
    private void mouseOnButtonTwo(){
        buttonTwo.setTextFill(Color.web("#ff0000"));
    }

    @FXML
    private void mouseOnButtonThree(){
        buttonThree.setTextFill(Color.web("#ff0000"));
    }

    @FXML
    private void mouseOnButtonNext(){
        buttonNext.setTextFill(Color.web("#ff0000"));
    }

    @FXML
    private void mouseOutButtonOne(){
        buttonOne.setTextFill(Color.web("#4b0082"));
    }

    @FXML
    private void mouseOutButtonTwo(){
        buttonTwo.setTextFill(Color.web("#4b0082"));
    }

    @FXML
    private void mouseOutButtonThree(){
        buttonThree.setTextFill(Color.web("#4b0082"));
    }

    @FXML
    private void mouseOutButtonNext(){
        buttonNext.setTextFill(Color.web("#4b0082"));
    }

    private void eat(int numberBag){
        player.getHero().eat(player.getBag().get(numberBag));
        notify(String.format("Вы съели %s, восстановлено %s здоровья!",
                player.getBag().get(numberBag).getName(), player.getBag().get(numberBag).getEnergy()));
        imageOfBagOne.setImage(null);
        player.getBag().remove(numberBag);
    }

    public void notify(String text){
        notifyTextThree.setText(notifyTextTwo.getText());
        notifyTextTwo.setText(notifyTextOne.getText());
        notifyTextOne.setText(text);
    }

    public void setHandlePoint(int handlePoint) {
        this.handlePoint = handlePoint;
    }

    public void setHealthNumber(int i){
        healthNumber.setText(String.format("Здоровье - %s", i));
    }

    public void setHealth(double i){
        health.setProgress(i/100);
    }

    public void isButtonNull (){
        buttonOne.setText("");
        buttonTwo.setText("");
        buttonThree.setText("");
        buttonNext.setText("");
    }
}