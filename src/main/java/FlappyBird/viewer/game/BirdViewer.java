package FlappyBird.viewer.game;

import FlappyBird.gui.GUI;
import FlappyBird.model.game.elements.Bird;

public class BirdViewer implements ElementViewer<Bird>{
    @Override
    public void draw(Bird bird, GUI gui) {
        gui.drawBird(bird.getPosition());
    }
}
