package Java.Data;

import Java.Data.Card.Deck;
import Java.Data.Card.Stack;
import Java.Data.Player.Player;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.mockito.Mockito.*;

public class GameTest {
    @Mock
    Deck mydeck;
    @Mock
    List<Stack> mystacks;
    @Mock
    Deck throwcard;
    @Mock
    List<Player> myplayers;
    @Mock
    FlowPane hand;
    @Mock
    Label playernamefx;
    @Mock
    Label playerpointfx;
    @Mock
    Label playeractionfx;
    @Mock
    Button start;
    @Mock
    FlowPane allstack;
    @Mock
    FlowPane stack1;
    @Mock
    FlowPane curentplayer;
    @Mock
    VBox resulttablefx;
    @InjectMocks
    Game game;

    @Before
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }
}

