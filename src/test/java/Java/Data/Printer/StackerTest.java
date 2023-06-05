package Java.Data.Printer;

import Java.Data.Card.Card;
import Java.Data.Card.Stack;
import org.junit.jupiter.api.Test;

class StackerTest {
    Stacker stacker = new Stacker();

    @Test
    void testStackerdefine() {
        stacker.stackerdefine(new Stack(new Card(0)));
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme