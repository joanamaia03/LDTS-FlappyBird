package FlappyBird.controller.game;

import FlappyBird.Game;
import FlappyBird.gui.GUI;
import FlappyBird.model.game.map.Map;
import FlappyBird.model.menu.Menu;
import FlappyBird.states.MenuState;

public class MapController extends GameController {
    private final BirdController birdController;
    private final PipeController pipeController;
    private boolean check = true;
    public MapController(Map map){
        super(map);
        this.birdController = new BirdController(map);
        this.pipeController = new PipeController(map);
    }
    public void step(Game game, GUI.ACTION action, long time) throws InterruptedException {
        if(check) {
            if (action == GUI.ACTION.SPACE) {
                if (action == GUI.ACTION.QUIT) game.setState(null);
                else if (getModel().isPipe(getModel().getBird().getPosition()) || getModel().isGround(getModel().getBird().getPosition())) {
                    Thread.sleep(4000);
                    game.setState(new MenuState(new Menu()));
                } else {
                    birdController.step(game, action, time);
                    pipeController.step(game, action, time);
                }
                check = false;
            }
        }
        else {
            if (action == GUI.ACTION.QUIT) game.setState(null);
            else if (getModel().isPipe(getModel().getBird().getPosition()) || getModel().isGround(getModel().getBird().getPosition())) {
                Thread.sleep(4000);
                game.setState(new MenuState(new Menu()));
            } else {
                birdController.step(game, action, time);
                pipeController.step(game, action, time);
            }
        }
    }
}
