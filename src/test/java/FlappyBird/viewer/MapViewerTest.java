package FlappyBird.viewer;

import FlappyBird.gui.GUI;
import FlappyBird.model.Position;
import FlappyBird.model.game.elements.Bird;
import FlappyBird.model.game.elements.Pipe;
import FlappyBird.model.game.map.Map;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import FlappyBird.viewer.game.GameViewer;

import java.io.IOException;
import java.util.Arrays;

class MapViewerTest {
    private GUI gui;
    private GameViewer viewer;
    private Map map;
    @BeforeEach
    void setUp(){
        map=new Map(40,20);
        gui= Mockito.mock(GUI.class);
        viewer=new GameViewer(map);
        map.setPipes(Arrays.asList(new Pipe(1,2), new Pipe(2,3), new Pipe(3,4)));map.setBird(new Bird(5,8));
    }
    @Test
    void drawPipes() throws IOException{
        viewer.draw(gui);
        Mockito.verify(gui, Mockito.times(1)).drawPipe(new Position(1,2));
        Mockito.verify(gui, Mockito.times(1)).drawPipe(new Position(2,3));
        Mockito.verify(gui, Mockito.times(1)).drawPipe(new Position(3,4));
        Mockito.verify(gui, Mockito.times(3)).drawPipe(Mockito.any(Position.class));
    }
    @Test
    void drawBird() throws IOException{
        viewer.draw(gui);
        Mockito.verify(gui, Mockito.times(1)).drawBird(new Position(5,8));
        Mockito.verify(gui, Mockito.times(1)).drawBird(Mockito.any(Position.class));
    }
    @Test
    void refreshAndClear() throws IOException{
        viewer.draw(gui);
        Mockito.verify(gui, Mockito.times(1)).clear();
        Mockito.verify(gui, Mockito.times(1)).refresh();
    }
}

