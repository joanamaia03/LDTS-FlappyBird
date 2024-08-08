package FlappyBird;

import FlappyBird.gui.GUI;
import FlappyBird.gui.LanternaGUI;
import FlappyBird.model.menu.Menu;
import FlappyBird.states.MenuState;
import FlappyBird.states.State;

import java.io.IOException;

public class Game {
    private final LanternaGUI gui;
    private State state;
    public Game() throws IOException {
        this.gui = new LanternaGUI(40,20);
        this.state = new MenuState(new Menu());
    }
    public static void main(String[] args) throws IOException, InterruptedException {
        new Game().run();
    }
    public GUI getGUI() {return gui;}
    public void setState(State state) {
        this.state = state;
    }
    public State getState() {return this.state;}
    public void run() throws IOException, InterruptedException {
        int FPS = 16;
        int frameTime = 1000/FPS;
        while(this.state != null) {
            long startTime = System.currentTimeMillis();
            state.step(this,gui,startTime);
            long elapsedTime = System.currentTimeMillis() - startTime;
            long sleepTime = frameTime - elapsedTime;
            try {
                if (sleepTime > 0) Thread.sleep(sleepTime);
            } catch (InterruptedException e){}
        }
        gui.close();
    }
}