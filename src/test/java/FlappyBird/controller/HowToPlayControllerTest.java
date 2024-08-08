package FlappyBird.controller;

import FlappyBird.Game;
import FlappyBird.controller.menu.HowToPlayController;
import FlappyBird.gui.GUI;
import FlappyBird.model.menu.HowToPlay;
import FlappyBird.states.HowToPlayState;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class HowToPlayControllerTest {
    private Game game;
    private HowToPlay howToPlay;
    private HowToPlayState howToPlayState;
    private HowToPlayController howToPlayController;

    @BeforeEach
    void setUp() throws IOException {
        game = new Game();
        howToPlay = new HowToPlay();
        howToPlayState = new HowToPlayState(howToPlay);
        howToPlayController = new HowToPlayController(howToPlay);
    }
    @Test
    void checkBack() {
        game.setState(howToPlayState);
        assertEquals(howToPlayState, game.getState());
        howToPlayController.step(game, GUI.ACTION.SELECT, 1000);
        assertNotEquals(howToPlayState, game.getState());
    }
}
