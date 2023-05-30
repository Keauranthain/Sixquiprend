package Data;

import java.util.List;

public abstract class Player {
    List<Card> hand;
    int point;

    public abstract void play();
}
