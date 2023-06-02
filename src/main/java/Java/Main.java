package Java;

import Java.Data.Card.Deck;
import Java.Data.Game;
import Java.Data.Printer.Printer;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

import static javafx.application.Application.launch;

public class Main extends Application {
    public static void main(String[] args) {
        launch();
        Game game = new Game(2,0);
        game.play();
    }
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Printer.class.getResource("/com/FX/sixquiprend.fxml"));
        Scene scene = new Scene(fxmlLoader.load(),800,500);
        //stage.getIcons().add(new Image(getClass().getResourceAsStream("bullhead.png")));
        stage.setTitle("Six qui Prend !");
        stage.setScene(scene);
        stage.show();
    }
}
