package FlappyBird.controller;

import FlappyBird.Game;
import FlappyBird.controller.game.PipeController;
import FlappyBird.gui.GUI;
import FlappyBird.model.Position;
import FlappyBird.model.game.elements.Pipe;
import FlappyBird.model.game.map.Map;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
class PipeControllerTest {
    private PipeController controller;
    private Map map;
    private Game game;

    @BeforeEach
    void setUp() {
        map = new Map(40,20);
        map.setPipes(Arrays.asList(new Pipe(20,10)));
        controller = new PipeController(map);
        game = Mockito.mock(Game.class);
    }

    @Test
    void movePipeLeft() {
        controller.step(game, GUI.ACTION.NONE, 1000);
        for(Pipe pipe : map.getPipes()) {
            assertEquals(new Position(19, 10), pipe.getPosition());
        }
    }
}
