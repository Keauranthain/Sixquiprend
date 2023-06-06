package Java.Data;

import Java.Data.Card.Card;
import Java.Data.Card.Deck;
import Java.Data.Card.Stack;
import Java.Data.Controler.LauncherControler;
import Java.Data.Player.AIplayer;
import Java.Data.Player.Player;
import Java.Data.Player.Realplayer;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
@Getter
public class Game implements Music{
    public Deck mydeck;
    public List<Stack> mystacks;
    public Deck throwcard;
    List<Player> myplayers;
    public Game (){
        Deck deck = new Deck();
        List<Stack> stacks = new ArrayList<>();
        List<Player> players = new ArrayList<>();
        deck.centraldeckmaker();
        for (int k = 0 ; k<4;k++) {
            stacks.add(new Stack(deck));
        }
        for (int k = 0 ; k<LauncherControler.real;k++) {
            players.add(new Realplayer("Player "+k));
        }
        for (int k = 0 ; k<LauncherControler.ai;k++) {
            players.add(new AIplayer("AI "+k));
        }
        this.mydeck=deck;
        this.mystacks=stacks;
        this.myplayers=players;
        this.throwcard=new Deck();
        Music.playMusic();
        user = -1;
    }
    private void gamestart (){
        for (int k=0;myplayers.size()>k;k++){
            myplayers.get(k).draw(mydeck);
        }
    }
    private void nextcard(){
        if (throwcard.size()==0 && teststillcard()){
            playernumber =0;
            stage = 1;
            nextplayer();
        } else if (throwcard.size()==0){
            showresult();
        }else {
            int start= throwcard.size();
            throwcard.merge();
            handsetup(throwcard.getplayer(0));
            stacker();
            int closer = -1;
            Card playercard = throwcard.getcard(0);
            int playercardnumber = playercard.getNumber();
            for (int i = 0; i < 4; i++) {
                int stackcard = mystacks.get(i).last();
                if (stackcard < playercardnumber && (closer == -1 || stackcard > mystacks.get(closer).last())) {
                    closer = i;
                }
            }
            if (closer == -1) {
                Player player = throwcard.getplayer(0);
                player.choose_stack(mystacks,throwcard);
            }else if (mystacks.get(closer).control()) {
                Player player = throwcard.getplayer(0);
                player.setPoint(player.getPoint() + mystacks.get(closer).point());
                player.addpoint(mystacks.get(closer),throwcard);
            }else {
                mystacks.get(closer).add(playercard);
                throwcard.remove(0);
            }
            user = -1;
            if (throwcard.size()<start){
                stacker();
                nextcard();
            }
        }
    }
    private void nextplayer(){
        if (playernumber == myplayers.size()){
            stage = 2;
            nextcard();
        }
        else {
            handsetup (myplayers.get(playernumber));
            myplayers.get(playernumber).play(mystacks,throwcard);
            user = -1;

            if (throwcard.size()>playernumber){
                playernumber++;
                nextplayer();
            }
        }
    }
    private void ranking(){
        myplayers = mergeA(myplayers);
    }
    private List<Player> mergeA(List<Player> players){
        List<Player> playersfinal;
        if (players.size()>1){
            int cut = players.size()/2;
            List<Player> playersA = new ArrayList<>(players.subList(0, cut));
            List<Player> playersB =new ArrayList<>(players.subList(cut, players.size()));
            playersfinal = mergeB(mergeA(playersA),mergeA(playersB));
        } else {
            playersfinal = new ArrayList<>(players);
        }
        return playersfinal;
    }
    private List<Player> mergeB(List<Player> playersA,List<Player> playersB){
        List<Player> playersfinal = new ArrayList<>();
        while (!playersA.isEmpty() && !playersB.isEmpty()){
            if(playersA.get(0).getPoint()>playersB.get(0).getPoint()){
                playersfinal.add(playersB.get(0));
                playersB.remove(0);
            }
            else {
                playersfinal.add(playersA.get(0));
                playersA.remove(0);
            }
        }
        playersfinal.addAll(playersA);
        playersfinal.addAll(playersB);
        return playersfinal;
    }







    private boolean teststillcard(){
        boolean result = false;
        for (int k = 0 ; k<myplayers.get(0).getHand().length;k++){
            if (myplayers.get(0).getHand()[k]!=null){
                result = true;
            }
        }
        return result;
    }
    private int stage;
    private int playernumber;
    public static int user;
    private String nocard = System.getProperty("user.dir")+"\\src\\main\\resources\\com\\FX\\Card\\nocard.png";
    @FXML
    private FlowPane hand;
    @FXML
    private Label playernamefx;
    @FXML
    private Label playerpointfx;
    @FXML
    private Label playeractionfx;
    @FXML
    private Button start;
    @FXML
    private FlowPane allstack;
    @FXML
    FlowPane stack1;
    @FXML
    private FlowPane curentplayer;

    @FXML
    private VBox resulttablefx;
    private void stacker() {
        for (int k = 0; 4 > k; k++) {
            Node node = allstack.getChildren().get(k);
            if (node instanceof FlowPane) {
                FlowPane stack = (FlowPane) node;
                setstack(mystacks.get(k),stack);
            }
        }
    }
    private void showresult(){
        ranking();
        resulttablefx.setVisible(true);
        curentplayer.setVisible(false);
        allstack.setVisible(false);
        for (int k = 0; k<myplayers.size();k++){
            Node node = resulttablefx.getChildren().get(k);
            if (node instanceof Label) {
                Label ranker = (Label) node;
                String rank = String.valueOf(k+1);
                if (k==0){
                    rank = rank +"er :";
                } else {
                    rank = rank +"eme :";
                }
                rank = rank +myplayers.get(k).getName()+"     score :"+myplayers.get(k).getPoint();
                ranker.setText(rank);
                ranker.setVisible(true);
            }
            else {
                System.out.println("Faux");
            }
        }
    }
    private void setstack(Stack stack, FlowPane stacker){
        for (int k = 0; k < 5; k++) {
            Node node = stacker.getChildren().get(k);
            if (stack.size()>k) {
                if (node instanceof ImageView) {
                    ImageView image = (ImageView) node;
                    image.setImage(new Image(stack.cardimage(k)));
                }
            } else if (node instanceof ImageView) {
                ImageView image = (ImageView) node;
                image.setImage(new Image(nocard));
            }
        }
    }
    private void startsetup(){
        start.setVisible(false);
        start.setDisable(true);
    }
    private void handsetup (Player player){
        Card[] playerhand = player.getHand();
        for (int k = 0 ; k<10 ; k++){
            Node node = hand.getChildren().get(k);
            if (playerhand[k]!=null) {
                if (node instanceof ImageView) {
                    ImageView image = (ImageView) node;
                    image.setImage(new Image(playerhand[k].getImage()));
                }
            }
            else if (node instanceof ImageView) {
                ImageView image = (ImageView) node;
                image.setImage(new Image(nocard));
            }
        }
        playernamefx.setText(player.getName());
        playerpointfx.setText(String.valueOf(player.getPoint()));
        if (stage == 1){
            playeractionfx.setText("Choix de carte");
        } else if (stage == 2){
            playeractionfx.setText("Choix de tas");
        }
    }
    @FXML
    private void begin (){
        startsetup();
        gamestart();
        stacker();
        stage = 1;
        nextplayer();
    }

    private void testcard(int n){
        if (stage == 1 && myplayers.get(playernumber).getHand()[n]!= null){
            user = n;
            nextplayer();
        }
    }
    @FXML
    private void inputcard0(){
        testcard(0);
    }
    @FXML
    private void inputcard1(){
        testcard(1);
    }
    @FXML
    private void inputcard2(){
        testcard(2);
    }
    @FXML
    private void inputcard3(){
        testcard(3);
    }
    @FXML
    private void inputcard4(){
        testcard(4);
    }
    @FXML
    private void inputcard5(){
        testcard(5);
    }
    @FXML
    private void inputcard6(){
        testcard(6);
    }
    @FXML
    private void inputcard7(){
        testcard(7);
    }
    @FXML
    private void inputcard8(){
        testcard(8);
    }
    @FXML
    private void inputcard9() {
        testcard(9);
    }
    private void teststack(int n){
        if (stage == 2){
            user = n;
            nextcard();
        }
    }
    @FXML
    private void inputstack0(){
        teststack(0);
    }
    @FXML
    private void inputstack1(){
        teststack(1);
    }
    @FXML
    private void inputstack2(){
        teststack(2);
    }
    @FXML
    private void inputstack3(){
        teststack(3);
    }

}
