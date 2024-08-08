package FlappyBird.controller;

import FlappyBird.Game;
import FlappyBird.controller.menu.MenuController;
import FlappyBird.gui.GUI;
import FlappyBird.model.menu.Menu;
import FlappyBird.states.MenuState;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class MenuControllerTest {
    private Game game;
    private Menu menu;
    private MenuState menuState;
    private MenuController menuController;

    @BeforeEach
    void setUp() throws IOException {
        game = new Game();
        menu = new Menu();
        menuState = new MenuState(menu);
        menuController = new MenuController(menu);
    }
    @Test
    void checkStart() {
        game.setState(menuState);
        assertEquals(menuState, game.getState());
        assertEquals(true, menu.isSelectedStart());
        menuController.step(game, GUI.ACTION.SELECT,1000);
        assertNotEquals(menuState, game.getState());
    }
    @Test
    void checkHowToPlay() {
        game.setState(menuState);
        assertEquals(menuState, game.getState());
        assertEquals(true, menu.isSelectedStart());
        menuController.step(game, GUI.ACTION.DOWN, 1000);
        assertEquals(true, menu.isSelectedHow());
        menuController.step(game, GUI.ACTION.SELECT, 1000);
        assertNotEquals(menuState, game.getState());
    }
    @Test
    void checkExit() {
        game.setState(menuState);
        assertEquals(menuState, game.getState());
        assertEquals(true, menu.isSelectedStart());
        menuController.step(game, GUI.ACTION.DOWN, 1000);
        assertEquals(true, menu.isSelectedHow());
        menuController.step(game, GUI.ACTION.DOWN, 1000);
        assertEquals(true, menu.isSelectedExit());
        menuController.step(game, GUI.ACTION.SELECT, 1000);
        assertNotEquals(menuState, game.getState());
        assertEquals(null, game.getState());
    }
}