package FlappyBird.viewer.menu;

import FlappyBird.gui.GUI;
import FlappyBird.model.Position;
import FlappyBird.model.menu.HowToPlay;
import FlappyBird.viewer.Viewer;

public class HowToPlayViewer extends Viewer<HowToPlay> {
    public HowToPlayViewer(HowToPlay howtoplay){ super(howtoplay);}
    @Override
    public void drawElements(GUI gui){
        gui.drawBackground();
        gui.drawTextMenu(new Position(14,4), "How To Play", "#FFFFFF");
        gui.drawTextMenu(new Position(7,6), "When in-game", "#FFFFFF");
        gui.drawTextMenu(new Position(7,7), "space is your best friend!", "#FFFFFF");
        gui.drawTextMenu(new Position(7,8), "Press space to begin and", "#FFFFFF");
        gui.drawTextMenu(new Position(7,9), "to go higher in the map.", "#FFFFFF");
        gui.drawTextMenu(new Position(7,10), "Pass through the pipes to", "#FFFFFF");
        gui.drawTextMenu(new Position(7,11), "get a higher score.", "#FFFFFF");
        gui.drawTextMenu(new Position(7,12), "Pretty simple, right?", "#FFFFFF");
        gui.drawTextMenu(new Position(17, 18), getModel().getEntry(0), "#FFD700");
    }
}