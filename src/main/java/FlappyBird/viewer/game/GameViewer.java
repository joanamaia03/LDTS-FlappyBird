package FlappyBird.viewer.game;

import FlappyBird.gui.GUI;
import FlappyBird.model.Position;
import FlappyBird.model.game.elements.Element;
import FlappyBird.model.game.map.Map;
import FlappyBird.viewer.Viewer;

import java.util.List;

public class GameViewer extends Viewer<Map> {
    public GameViewer(Map map) {
        super(map);
    }
    @Override
    public void drawElements(GUI gui) {
        gui.drawBackground();
        drawElements(gui, getModel().getPipes(), new PipeViewer());
        gui.drawScore(getModel().getScore(), "#FFFFFF");
        drawElement(gui, getModel().getBird(), new BirdViewer());
        if (getModel().isPipe(getModel().getBird().getPosition()) || getModel().isGround(getModel().getBird().getPosition())){
            gui.drawBackground();
            gui.drawTextGame(new Position(gui.getWidth()/2-4, gui.getHeight()/2-1),"You Died", "#FFFFFF");
        }
    }
    private <T extends Element> void drawElements(GUI gui, List<T> elements, ElementViewer<T> viewer) {
        for (T element : elements) drawElement(gui, element, viewer);
    }
    private <T extends Element> void drawElement(GUI gui, T element, ElementViewer<T> viewer) {
        viewer.draw(element, gui);
    }
}
