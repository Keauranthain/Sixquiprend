package Java.Data;

import Java.Data.Card.Card;
import Java.Data.Card.Deck;
import Java.Data.Card.Stack;
import Java.Data.Player.Player;
import Java.Data.Player.Realplayer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.mockito.Mockito.*;

class GameTest {
    @Mock
    Deck mydeck;
    @Mock
    List<Stack> mysacks;
    @Mock
    Deck throwcard;
    @Mock
    List<Player> myplayers;
    @InjectMocks
    Game game;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testPlay() {
        when(mydeck.size()).thenReturn(0);
        when(mydeck.get(anyInt())).thenReturn(0);
        when(mydeck.getcard(anyInt())).thenReturn(new Card(0));
        when(mydeck.getplayer(anyInt())).thenReturn(new Realplayer("name"));
        when(throwcard.size()).thenReturn(0);
        when(throwcard.get(anyInt())).thenReturn(0);
        when(throwcard.getcard(anyInt())).thenReturn(new Card(0));
        when(throwcard.getplayer(anyInt())).thenReturn(new Realplayer("name"));

        game.play();
    }
}

