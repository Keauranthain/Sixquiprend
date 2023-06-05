package Java.Data.Controler;

import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import lombok.Getter;

@Getter
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
    public void closeWindow() {
        if (ai+real>1) {
            Stage stage = (Stage) AILabel.getScene().getWindow();
            stage.close();
        }
    }

}
