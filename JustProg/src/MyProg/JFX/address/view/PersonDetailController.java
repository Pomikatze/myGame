package MyProg.JFX.address.view;

import MyProg.JFX.address.MainApp;
import MyProg.JFX.address.model.entity.Player;
import MyProg.JFX.address.model.entity.heroes.Paladin;
import MyProg.JFX.address.model.entity.heroes.War;
import MyProg.JFX.address.model.entity.heroes.Wizard;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class PersonDetailController {
    @FXML
    private ImageView personIcon;
    @FXML
    private Label personName;
    @FXML
    private TextArea personDetails;
    @FXML
    private ImageView bagOne;
    @FXML
    private ImageView bagTwo;
    @FXML
    private ImageView bagThree;
    @FXML
    private ImageView bagFour;
    @FXML
    private ImageView bagFive;
    @FXML
    private ImageView bagSix;

    private MainApp mainApp;
    private Stage dialogStage;
    private ImageView[] bags = new ImageView[6];

    public void init (Player player){
        bags[0] = bagOne;
        bags[1] = bagTwo;
        bags[2] = bagThree;
        bags[3] = bagFour;
        bags[4] = bagFive;
        bags[5] = bagSix;

        if (player.getHero().getClass().equals(War.class)){
            personIcon.setImage(new Image("file:src/resources/Warrior.png"));
            personDetails.setText(String.format("Здоровье - %s\n" +
                    "Сила - 30\n" +
                    "Броня - 15\n" +
                    "Способнось - Удар с двух рук\n" +
                    "Могучий воин. Бывший офицер Легиона.\n" +
                    "Способен наносить двойной урон", player.getHero().getHealth()));
        } else if (player.getHero().getClass().equals(Paladin.class)){
            personIcon.setImage(new Image("file:src/resources/Paladin.png"));
            personDetails.setText(String.format("Здоровье - %s\n" +
                    "Сила - 25\n" +
                    "Броня - 20\n" +
                    "Способнось - Вампиризм\n" +
                    "Служитель света. После падения своего ордена,\n" +
                    "пообещал себе бороться со злом\n" +
                    "Способен красть здоровье противника", player.getHero().getHealth()));
        } else if (player.getHero().getClass().equals(Wizard.class)){
            personIcon.setImage(new Image("file:src/resources/priest.png"));
            personDetails.setText(String.format("Здоровье - %s\n" +
                    "Сила - 20\n" +
                    "Броня - 15\n" +
                    "Способнось - Лечение\n" +
                    "Был врачом во время великой войны.\n" +
                    "Затем обратился в веру.\n" +
                    "Способен восстанавливать здоровье", player.getHero().getHealth()));
        }

        personName.setText(player.getHero().getName());

        for (int i = 0; i < player.getBag().size(); i++) {
            bags[i].setImage(new Image(player.getBag().get(i).getImageURL()));
        }
    }

    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
    }

    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }
}
