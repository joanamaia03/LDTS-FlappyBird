package FlappyBird;

import FlappyBird.model.game.map.Map;
import FlappyBird.model.menu.HowToPlay;
import FlappyBird.model.menu.Menu;
import FlappyBird.states.GameState;
import FlappyBird.states.HowToPlayState;
import FlappyBird.states.MenuState;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {
    private Game game;
    private MenuState menu1;
    private GameState menu2;
    private HowToPlayState menu3;
    private Map map;
    @BeforeEach
    void setUp() throws IOException {
        map = new Map(40,20);
        game = new Game();
        menu1 = new MenuState(new Menu());
        menu2 = new GameState(map);
        menu3 = new HowToPlayState(new HowToPlay());
    }
    @Test
    void Game() {
        assertNotNull(game.getState());
    }

    @Test
    void setState() {
        assertNotEquals(menu1,game.getState());
        game.setState(menu1);
        assertEquals(menu1, game.getState());
        game.setState(menu2);
        assertEquals(menu2, game.getState());
        game.setState(menu3);
        assertEquals(menu3, game.getState());
    }
}