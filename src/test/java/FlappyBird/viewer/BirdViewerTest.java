package FlappyBird.viewer;

import FlappyBird.gui.GUI;
import FlappyBird.model.game.elements.Bird;
import FlappyBird.viewer.game.BirdViewer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class BirdViewerTest {
    private Bird bird;
    private BirdViewer viewer;
    private GUI gui;

    @BeforeEach
    void setUp() {
        bird = new Bird(10,10);
        viewer = new BirdViewer();
        gui = Mockito.mock(GUI.class);
    }

    @Test
    void drawElements() {
        viewer.draw(bird, gui);
        Mockito.verify(gui, Mockito.times(1)).drawBird(bird.getPosition());
    }
}
