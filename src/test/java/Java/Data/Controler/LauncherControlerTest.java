package Java.Data.Controler;

import javafx.scene.control.Label;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.*;

public class LauncherControlerTest {
    @Mock
    Label AILabel;
    @Mock
    Label RealLabel;
    @InjectMocks
    LauncherControler launcherControler;

    @Before
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testAiplus() throws Exception {
        launcherControler.aiplus();
    }

    @Test
    public void testAiminus() throws Exception {
        launcherControler.aiminus();
    }

    @Test
    public void testRealplus() throws Exception {
        launcherControler.realplus();
    }

    @Test
    public void testRealminus() throws Exception {
        launcherControler.realminus();
    }

    @Test
    public void testCloseWindow() throws Exception {
        launcherControler.closeWindow();
    }
}

