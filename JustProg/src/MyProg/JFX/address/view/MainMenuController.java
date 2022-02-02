package MyProg.JFX.address.view;

import MyProg.JFX.address.MainApp;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;

public class MainMenuController {
    @FXML
    private CheckBox music;

    MainApp mainApp;

    public MainMenuController() {
    }

    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
    }

    @FXML
    private void handleNewGame(){
        mainApp.showChoice();
        mainApp.windowHide();
    }

    @FXML
    private void handleLoad(){
    }

    @FXML
    private void handleExit(){
        mainApp.closeApp();
    }

    @FXML
    private void handleMusic(){
        if (music.isSelected()){
            mainApp.musicOff();
        } else mainApp.musicOn();
    }
}
