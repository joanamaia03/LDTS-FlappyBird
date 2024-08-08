package FlappyBird.viewer.game;

import FlappyBird.gui.GUI;
import FlappyBird.model.game.elements.Element;

public interface ElementViewer<T extends Element> {
    void draw(T element, GUI gui);
}
