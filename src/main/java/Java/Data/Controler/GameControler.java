package Java.Data.Controler;

import Java.Data.Game;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;

public class GameControler {
    @FXML
    private void stacker(Scene scene){
        for (int k = 1; 1+ Game.mysacks.size()>k; k++){
            String id = "#stack"+k;
            FlowPane stack = (FlowPane) scene.lookup(id);
            for (int i = 0 ; Game.mysacks.get(k).size()>i; i++){
                if (Game.mysacks.get(k).getMystack().get(i)!=null) {
                    Node node = stack.getChildren().get(i);
                    if (node instanceof ImageView) {
                        ImageView image = (ImageView) node;
                        image.setImage(new Image(Game.mysacks.get(k).cardimage(i)));
                        System.out.println(Game.mysacks.get(k).cardimage(i));
                    }
                }
            }
        }
    }
}
