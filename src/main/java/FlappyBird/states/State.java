package FlappyBird.states;

import FlappyBird.Game;
import FlappyBird.controller.Controller;
import FlappyBird.gui.GUI;
import FlappyBird.viewer.Viewer;

import java.io.IOException;

public abstract class State<T> {
    private final T model;
    private final Controller<T> controller;
    private final Viewer<T> viewer;
    public State(T model) {
        this.model = model;
        this.viewer = getViewer();
        this.controller = getController();
    }
    protected abstract Viewer<T> getViewer();
    protected abstract Controller<T> getController();
    public T getModel() {
        return model;
    }
    public void step(Game game, GUI gui, long time) throws IOException, InterruptedException {
        GUI.ACTION action = gui.getNextAction();
        controller.step(game, action, time);
        viewer.draw(gui);
    }
}
