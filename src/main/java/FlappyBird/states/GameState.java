package FlappyBird.states;

import FlappyBird.controller.Controller;
import FlappyBird.controller.game.MapController;
import FlappyBird.model.game.map.Map;
import FlappyBird.viewer.Viewer;
import FlappyBird.viewer.game.GameViewer;

public class GameState extends State<Map>{
    public GameState(Map map) {
        super(map);
    }
    @Override
    protected Viewer<Map> getViewer() {
        return new GameViewer(getModel());
    }
    @Override
    protected Controller<Map> getController() {
        return new MapController(getModel());
    }
}
