package Java;

import org.junit.jupiter.api.Test;

import java.io.IOException;

class MainTest {
    //Field hostServices of type HostServices - was not mocked since Mockito doesn't mock a Final class when 'mock-maker-inline' option is not set
    Main main = new Main();

    @Test
    void testMain() {
        Main.main(new String[]{"args"});
    }

    @Test
    void testStart() throws IOException {
        main.start(null);
    }
}

