package FlappyBird.controller.game;

import FlappyBird.Game;
import FlappyBird.gui.GUI;
import FlappyBird.model.Position;
import FlappyBird.model.game.map.Map;

public class BirdController extends GameController {
    public BirdController(Map map) {
        super(map);
    }
    public void moveBirdJump(){
        if(getModel().isCeiling(getModel().getBird().getPosition().getJump())) moveBird(getModel().getBird().getPosition().getCeiling());
        else moveBird(getModel().getBird().getPosition().getJump());
    }
    private void moveBird(Position position) {
        getModel().getBird().setPosition(position);
    }
    @Override
    public void step(Game game, GUI.ACTION action, long time) {
        if (action == GUI.ACTION.SPACE) moveBirdJump();
        else fall();
    }
    public void fall(){
        moveBird(getModel().getBird().getPosition().getFall());
    }
}
