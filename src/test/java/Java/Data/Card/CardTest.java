package Java.Data.Card;

import Java.Data.Player.Player;
import Java.Data.Player.Realplayer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;


class CardTest {
    @Mock
    Player myplayer;
    @InjectMocks
    Card card;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testSetNumber() {
        card.setNumber(0);
    }

    @Test
    void testSetBullhead() {
        card.setBullhead(0);
    }

    @Test
    void testSetMyplayer() {
        card.setMyplayer(new Realplayer("name"));
    }

    @Test
    void testSetImage() {
        card.setImage("image");
    }
}

