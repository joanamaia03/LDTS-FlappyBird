package FlappyBird.controller.game;

import FlappyBird.Game;
import FlappyBird.gui.GUI;
import FlappyBird.model.game.elements.Pipe;
import FlappyBird.model.game.map.Map;

public class PipeController extends GameController {
    public PipeController(Map map) {
        super(map);
    }
    public void movePipeLeft(){
        for(Pipe pipe : getModel().getPipes()) pipe.setPosition(pipe.getPosition().getLeft());
    }
    @Override
    public void step(Game game, GUI.ACTION action, long time) {
        movePipeLeft();
    }
}
