package FlappyBird.controller.menu;

import FlappyBird.Game;
import FlappyBird.controller.Controller;
import FlappyBird.gui.GUI;
import FlappyBird.model.menu.HowToPlay;
import FlappyBird.model.menu.Menu;
import FlappyBird.states.MenuState;

public class HowToPlayController extends Controller<HowToPlay> {
    public HowToPlayController (HowToPlay howtoplay) {super(howtoplay);}

    @Override
    public void step(Game game, GUI.ACTION action, long time){
        switch(action){
            case SELECT:
                game.setState(new MenuState(new Menu()));
        }
    }
}
