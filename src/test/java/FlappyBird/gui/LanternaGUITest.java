package FlappyBird.gui;

import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.Screen;
import FlappyBird.model.Position;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LanternaGUITest {
    private Screen screen;
    private LanternaGUI gui;
    private TextGraphics tg;

    @BeforeEach
    void setUp(){
        screen = Mockito.mock(Screen.class);
        tg = Mockito.mock(TextGraphics.class);
        
        Mockito.when(screen.newTextGraphics()).thenReturn(tg);

        gui = new LanternaGUI(screen);
    }

    @Test
    void drawBird(){
        gui.drawBird(new Position(1,1));

        Mockito.verify(tg, Mockito.times(1)).setForegroundColor(new TextColor.RGB (255, 255, 0));
        Mockito.verify(tg, Mockito.times(1)).setBackgroundColor(new TextColor.RGB (55, 198, 255));
        Mockito.verify(tg, Mockito.times(1)).putString(1,2,"V", SGR.BOLD);
    }

    @Test
    void drawTextMenu(){
        gui.drawTextMenu(new Position(1, 1), "Hello World", "#336699");

        Mockito.verify(tg, Mockito.times(1)).setForegroundColor(new TextColor.RGB(51, 102, 153));
        Mockito.verify(tg, Mockito.times(1)).setBackgroundColor(new TextColor.RGB (55, 198, 255));
        Mockito.verify(tg, Mockito.times(1)).putString(1, 1, "Hello World", SGR.BOLD);
    }

    @Test
    void drawTextGame(){
        gui.drawTextGame(new Position(1, 1), "Hello World", "#336699");

        Mockito.verify(tg, Mockito.times(1)).setForegroundColor(new TextColor.RGB(51, 102, 153));
        Mockito.verify(tg, Mockito.times(1)).setBackgroundColor(new TextColor.RGB (55, 198, 255));
        Mockito.verify(tg, Mockito.times(1)).putString(1, 1, "Hello World", SGR.BOLD, SGR.BLINK);
    }
    @Test
    void drawScore(){
        gui.drawScore("999", "#FFFFFF");

        Mockito.verify(tg, Mockito.times(1)).setForegroundColor(new TextColor.RGB(255, 255, 255));
        Mockito.verify(tg, Mockito.times(1)).setBackgroundColor(new TextColor.RGB (55, 198, 255));
        Mockito.verify(tg, Mockito.times(1)).putString(gui.getWidth()/2-1, 2, "999", SGR.BOLD);
    }

    @Test
    void drawBackground(){
        gui.drawBackground();

        Mockito.verify(tg, Mockito.times(1)).setBackgroundColor(new TextColor.RGB (55, 198, 255));
        Mockito.verify(tg, Mockito.times(1)).fillRectangle(new TerminalPosition(0, 0), new TerminalSize(40,20), ' ');
    }

    @Test
    void drawPipe(){
        gui.drawPipe(new Position(1,1));

        Mockito.verify(tg, Mockito.times(1)).setForegroundColor(new TextColor.RGB (3, 172, 19));
        Mockito.verify(tg, Mockito.times(1)).setBackgroundColor(new TextColor.RGB (3, 172, 19));
        Mockito.verify(tg, Mockito.times(1)).putString(1,2," ", SGR.BOLD);
    }
    @Test
    void getWidth(){
        assertEquals(40, gui.getWidth());
    }
    @Test
    void getHeight(){
        assertEquals(20, gui.getHeight());
    }
    @Test
    void clear(){
        gui.clear();
        Mockito.verify(screen, Mockito.times(1)).clear();
    }
    @Test
    void refresh() throws IOException {
        gui.refresh();
        Mockito.verify(screen, Mockito.times(1)).refresh();
    }
    @Test
    void close() throws IOException {
        gui.close();
        Mockito.verify(screen, Mockito.times(1)).close();
    }
}
