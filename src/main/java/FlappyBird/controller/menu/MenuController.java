package FlappyBird.controller.menu;

import FlappyBird.Game;
import FlappyBird.controller.Controller;
import FlappyBird.gui.GUI;
import FlappyBird.model.game.map.MapBuilder;
import FlappyBird.model.menu.HowToPlay;
import FlappyBird.model.menu.Menu;
import FlappyBird.states.GameState;
import FlappyBird.states.HowToPlayState;

public class MenuController extends Controller<Menu> {
    public MenuController (Menu menu) {super(menu);}

    @Override
    public void step(Game game, GUI.ACTION action, long time) {
        switch(action){
            case UP:
                getModel().previousEntry();
                break;
            case DOWN:
                getModel().nextEntry();
                break;
            case SELECT:
                if (getModel().isSelectedExit()) game.setState(null);
                if (getModel().isSelectedHow()) game.setState(new HowToPlayState(new HowToPlay()));
                if (getModel().isSelectedStart()) game.setState(new GameState(new MapBuilder(40,20).createMap()));
        }
    }
}
