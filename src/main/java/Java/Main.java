package Java;

import Java.Data.Card.Deck;
import Java.Data.Controler.LauncherControler;
import Java.Data.Game;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;


public class Main extends Application{
    public static void main(String[] args) {
        launch();
    }
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Game.class.getResource("/com/FX/sixquiprendLauncher.fxml"));
        Scene scene = new Scene(fxmlLoader.load(),800,500);
        //stage.getIcons().add(new Image(getClass().getResourceAsStream("bullhead.png")));
        stage.setTitle("Launcher");
        stage.setScene(scene);
        stage.show();
    }
}
