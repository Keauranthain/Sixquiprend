package Java.Data.Printer;

import org.junit.jupiter.api.BeforeEach;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.*;

class PrinterTest {
    @Mock
    Stacker stackA;
    @Mock
    Stacker stackB;
    @Mock
    Stacker stackC;
    @Mock
    Stacker stackD;
    @InjectMocks
    Printer printer;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme