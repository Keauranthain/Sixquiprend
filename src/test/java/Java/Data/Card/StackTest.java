package Java.Data.Card;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;

class StackTest {
    @Mock
    List<Card> mystack;
    @InjectMocks
    Stack stack;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testControl() {
        boolean result = stack.control();
        Assertions.assertEquals(true, result);
    }

    @Test
    void testPoint() {
        int result = stack.point();
        Assertions.assertEquals(0, result);
    }

    @Test
    void testSize() {
        int result = stack.size();
        Assertions.assertEquals(0, result);
    }

    @Test
    void testLast() {
        int result = stack.last();
        Assertions.assertEquals(0, result);
    }

    @Test
    void testAdd() {
        stack.add(new Card(0));
    }

    @Test
    void testSetMystack() {
        stack.setMystack(List.of(new Card(0)));
    }
}

