package Java.Data.Player;

import Java.Data.Card.Card;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class AIplayerTest {
    //Field hand of type Card[] - was not mocked since Mockito doesn't mock arrays
    AIplayer aIplayer = new AIplayer("name");

    //@Test
    //void testChoose_card() {
    //    int result = aIplayer.choose_card();
    //    Assertions.assertEquals(0, result);
    //}

    //@Test
    //void testChoose_stack() {
    //    int result = aIplayer.choose_stack();
    //    Assertions.assertEquals(0, result);
    //}

    //@Test
    //void testPlay() {
    //    aIplayer.play();
    //}

    //@Test
    //void testDraw() {
    //    aIplayer.draw();
    //}

    @Test
    void testSetHand() {
        aIplayer.setHand(new Card[]{new Card(0)});
    }

    @Test
    void testSetPoint() {
        aIplayer.setPoint(0);
    }

    @Test
    void testSetName() {
        aIplayer.setName("name");
    }
}

