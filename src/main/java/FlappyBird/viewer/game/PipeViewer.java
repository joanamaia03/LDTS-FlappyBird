package FlappyBird.viewer.game;

import FlappyBird.gui.GUI;
import FlappyBird.model.game.elements.Pipe;

public class PipeViewer implements ElementViewer<Pipe> {
    @Override
    public void draw(Pipe pipe, GUI gui) {
        gui.drawPipe(pipe.getPosition());
    }
}
