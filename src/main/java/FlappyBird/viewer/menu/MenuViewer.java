package FlappyBird.viewer.menu;

import FlappyBird.gui.GUI;
import FlappyBird.model.Position;
import FlappyBird.model.menu.Menu;
import FlappyBird.viewer.Viewer;

public class MenuViewer extends Viewer<Menu> {
    public MenuViewer(Menu menu){ super(menu);}
    @Override
    public void drawElements(GUI gui){
        gui.drawBackground();
        gui.drawTextMenu(new Position(15,7), "FLAPPY BIRD", "#FFFFFF");
        for(int i=0; i < getModel().getNumberEntries();i++)
            gui.drawTextMenu(
                    new Position(20-(getModel().getEntry(i).length()/2), 9 + i),
                    getModel().getEntry(i),
                    getModel().isSelected(i) ? "#FFD700" : "#FFFFFF");
    }
}

