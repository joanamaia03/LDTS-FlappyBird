package FlappyBird.states;

import FlappyBird.controller.Controller;
import FlappyBird.controller.menu.MenuController;
import FlappyBird.model.menu.Menu;
import FlappyBird.viewer.Viewer;
import FlappyBird.viewer.menu.MenuViewer;

public class MenuState extends State<Menu> {
    public MenuState(Menu model){ super(model);}

    @Override
    protected Viewer<Menu> getViewer(){
        return new MenuViewer(getModel());
    }

    @Override
    protected Controller<Menu> getController(){
        return new MenuController(getModel());
    }
}
