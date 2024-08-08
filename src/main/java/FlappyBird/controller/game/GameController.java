package FlappyBird.controller.game;

import FlappyBird.controller.Controller;
import FlappyBird.model.game.map.Map;

public abstract class GameController extends Controller<Map> {
    public GameController(Map map) {
        super(map);
    }
}
