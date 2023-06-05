package Java.Data.Player;

import Java.Data.Card.Card;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class RealplayerTest {
    //Field hand of type Card[] - was not mocked since Mockito doesn't mock arrays
    Realplayer realplayer = new Realplayer("name");

    @Test
    void testChoose_card() {
        int result = realplayer.choose_card();
        Assertions.assertEquals(0, result);
    }

    @Test
    void testChoose_stack() {
        int result = realplayer.choose_stack();
        Assertions.assertEquals(0, result);
    }

    @Test
    void testPlay() {
        realplayer.play();
    }

    @Test
    void testDraw() {
        realplayer.draw();
    }

    @Test
    void testSetHand() {
        realplayer.setHand(new Card[]{new Card(0)});
    }

    @Test
    void testSetPoint() {
        realplayer.setPoint(0);
    }

    @Test
    void testSetName() {
        realplayer.setName("name");
    }
}

