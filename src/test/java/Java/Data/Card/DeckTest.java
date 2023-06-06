package Java.Data.Card;

import Java.Data.Player.Player;
import Java.Data.Player.Realplayer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;

class DeckTest {
    @Mock
    List<Card> mydeck;
    @InjectMocks
    Deck deck;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testCentraldeckmaker() {
        deck.centraldeckmaker();
    }

    @Test
    void testDraw() {
        deck.draw(0, new Deck());
    }

    @Test
    void testMerge() {
        deck.merge();
    }

    @Test
    void testAdd() {
        deck.add(new Card(0));
    }

    @Test
    void testClear() {
        deck.clear();
    }

    @Test
    void testSize() {
        int result = deck.size();
        Assertions.assertEquals(0, result);
    }

    @Test
    void testGet() {
        int result = deck.get(0);
        Assertions.assertEquals(0, result);
    }

    @Test
    void testGetcard() {
        Card result = deck.getcard(0);
        Assertions.assertEquals(new Card(0), result);
    }

    @Test
    void testGetplayer() {
        Player result = deck.getplayer(0);
        Assertions.assertEquals(new Realplayer("name"), result);
    }

    @Test
    void testRemove() {
        deck.remove(0);
    }

    @Test
    void testSetMydeck() {
        deck.setMydeck(List.of(new Card(0)));
    }
}

