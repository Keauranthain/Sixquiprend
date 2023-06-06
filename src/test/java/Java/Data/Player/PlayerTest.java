package Java.Data.Player;

import Java.Data.Card.Card;
import org.junit.jupiter.api.Test;

class PlayerTest {
    //Field hand of type Card[] - was not mocked since Mockito doesn't mock arrays
    Player player = new Realplayer("name");

    //@Test
    //void testPlay() {
    //    player.play();
    //}

    //@Test
    //void testDraw() {
    //    player.draw();
    //}

    @Test
    void testSetHand() {
        player.setHand(new Card[]{new Card(0)});
    }

    @Test
    void testSetPoint() {
        player.setPoint(0);
    }

    @Test
    void testSetName() {
        player.setName("name");
    }
}

