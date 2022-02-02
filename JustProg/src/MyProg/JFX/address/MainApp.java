package MyProg.JFX.address;

import MyProg.JFX.address.model.entity.Player;
import MyProg.JFX.address.view.ChapterOneController;
import MyProg.JFX.address.view.ChoiceController;
import MyProg.JFX.address.view.MainMenuController;
import MyProg.JFX.address.view.PersonDetailController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;


public class MainApp extends Application {
    private Stage primaryStage;
    private BorderPane rootLayout;
    private String musicFile = "src/resources/MainMusic.mp3";
    private Media sound = new Media(new File(musicFile).toURI().toString());
    private MediaPlayer mediaPlayer = new MediaPlayer(sound);
    private String mainIconUrl = "file:src/resources/icon.png";

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("The World of Magic");
        this.primaryStage.getIcons().add(new Image(mainIconUrl));


        initRootLayout();

        showMainMenu();
    }

    /**
     * Инициализирует корневой проект
     */
    public void initRootLayout() {
        try {
            // Загружаем корнеой проект
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/RootLayout.fxml"));
            rootLayout = (BorderPane) loader.load();

            // Отображаем сцену, содержащую корневой проект
            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.setResizable(false);
            primaryStage.show();
            primaryStage.setTitle("The World of Magic");

            mediaPlayer.play();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Stage getPrimaryStage() {
        return primaryStage;
    }

    public void showMainMenu(){
        try {
            // Загружаем сведения об адресатах
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/MainMenuView.fxml"));
            AnchorPane personOverview = (AnchorPane) loader.load();

            // Помещаем сведения об адресатах в центр корневого макета.
            rootLayout.setCenter(personOverview);

            //Даём контроллеру доступ к главному приложению
            MainMenuController controller = loader.getController();
            controller.setMainApp(this);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void closeApp(){
        primaryStage.close();
    }

    public void musicOff(){
        mediaPlayer.pause();
    }

    public void musicOn(){
        mediaPlayer.play();
    }

    public void windowHide(){
        primaryStage.setOpacity(0);
    }

    public void showChoice(){
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/Choice.fxml"));
            AnchorPane page = (AnchorPane) loader.load();

            Stage dialogStage = new Stage();
            dialogStage.setTitle("Выберете Персонажа");
            dialogStage.initOwner(primaryStage);
            Scene scene = new Scene(page);
            dialogStage.setScene(scene);
            dialogStage.setResizable(false);
            dialogStage.getIcons().add(new Image(mainIconUrl));

            ChoiceController controller = loader.getController();
            controller.setDialogStage(dialogStage);
            controller.setMainApp(this);

            dialogStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void showChaptOne(Player player){
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/ChaptOne.fxml"));
            AnchorPane page = (AnchorPane) loader.load();

            Stage dialogStage = new Stage();
            dialogStage.setTitle("Пролог");
            Scene scene = new Scene(page);
            dialogStage.setScene(scene);
            dialogStage.setResizable(false);
            dialogStage.getIcons().add(new Image(mainIconUrl));

            ChapterOneController controller = loader.getController();
            controller.setMainApp(this);
            controller.setDialogStage(dialogStage);
            controller.setMediaPlayer(mediaPlayer);

            dialogStage.show();

            controller.start(player);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void showPersonDetails(Player player){
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/PersonDetails.fxml"));
            AnchorPane page = (AnchorPane) loader.load();

            Stage dialogStage = new Stage();
            dialogStage.setTitle("Детализация");
            Scene scene = new Scene(page);
            dialogStage.setScene(scene);
            dialogStage.setResizable(false);
            dialogStage.getIcons().add(new Image(mainIconUrl));

            PersonDetailController controller = loader.getController();
            controller.setMainApp(this);
            controller.setDialogStage(dialogStage);

            dialogStage.show();

            controller.init(player);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}