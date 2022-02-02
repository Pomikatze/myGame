package MyProg.JFX.address.view;

import MyProg.JFX.address.MainApp;
import MyProg.JFX.address.model.entity.Food;
import MyProg.JFX.address.model.entity.Player;
import MyProg.JFX.address.model.entity.heroes.Paladin;
import MyProg.JFX.address.model.entity.heroes.War;
import MyProg.JFX.address.model.entity.heroes.Wizard;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;


public class ChoiceController {
    @FXML
    TextField name;

    private Stage dialogStage;
    private MainApp mainApp;

    public ChoiceController() {
    }

    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
    }

    public void setDialogStage (Stage dialogStage){
        this.dialogStage = dialogStage;
    }

    @FXML
    private void handleWar(){
        if (name.getText().equals("")){
            alert("Имя персонажа не может быть пустым!");
        } else if (name.getText().length() > 7){
            alert("Имя персонажа не может быть длиннее 7 символов!");
        } else {
            Player player = new Player();
            War war = new War(name.getText());
            int maxSizeBag = 6;
            List<Food> bag = new ArrayList<>(maxSizeBag);
            player.setBag(bag);
            player.setHero(war);

            mainApp.showChaptOne(player);

            dialogStage.close();
        }
    }

    @FXML
    private void handlePal(){
        if (name.getText().equals("")){
            alert("Имя персонажа не может быть пустым!");
        } else if (name.getText().length() > 7){
            alert("Имя персонажа не может быть длиннее 7 символов!");
        } else {
            Player player = new Player();
            Paladin pal = new Paladin(name.getText());
            int maxSizeBag = 6;
            List<Food> bag = new ArrayList<>(maxSizeBag);
            player.setBag(bag);
            player.setHero(pal);

            mainApp.showChaptOne(player);

            dialogStage.close();
        }
    }

    @FXML
    private void handlePriest(){
        if (name.getText().equals("")){
            alert("Имя персонажа не может быть пустым!");
        } else if (name.getText().length() > 7){
            alert("Имя персонажа не может быть длиннее 7 символов!");
        } else {
            Player player = new Player();
            Wizard wizard = new Wizard(name.getText());
            int maxSizeBag = 6;
            List<Food> bag = new ArrayList<>(maxSizeBag);
            player.setBag(bag);
            player.setHero(wizard);

            mainApp.showChaptOne(player);

            dialogStage.close();
        }
    }

    private void alert (String text){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.initOwner(dialogStage);
        alert.setTitle("Ошибка!");
        alert.setHeaderText("Введите имя персонажа!");
        alert.setContentText(text);

        alert.showAndWait();
    }
}
