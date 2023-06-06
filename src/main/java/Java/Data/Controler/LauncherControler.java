package Java.Data.Controler;

import Java.Data.Game;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

public class LauncherControler {
    public static int ai;
    public static int real = 2;
    @FXML
    private Label AILabel;
    @FXML
    private Label RealLabel;
    public LauncherControler(){}
    @FXML
    protected void aiplus(){
        if (ai+real<10){
            ai++;
        }
        AILabel.setText(String.valueOf(ai));
    }
    @FXML
    protected void aiminus(){
        if (ai>0){
            ai=ai-1;
        }
        AILabel.setText(String.valueOf(ai));
    }
    @FXML
    protected void realplus(){
        if (ai+real<10){
            real++;
        }
        RealLabel.setText(String.valueOf(real));
    }
    @FXML
    protected void realminus(){
        if (real>0){
            real=real-1;
        }
        RealLabel.setText(String.valueOf(real));
    }
    @FXML
    public void closeWindow() throws IOException {
        if (ai+real>1) {
            Stage stage = (Stage) AILabel.getScene().getWindow();
            FXMLLoader fxmlLoader = new FXMLLoader(Game.class.getResource("/com/FX/sixquiprend.fxml"));
            Scene scene = new Scene(fxmlLoader.load(),800,500);
            //stage.getIcons().add(new Image(getClass().getResourceAsStream("bullhead.png")));
            stage.setTitle("Six qui prend !");
            stage.setScene(scene);
        }
    }

}
