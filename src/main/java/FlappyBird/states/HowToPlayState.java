package FlappyBird.states;

import FlappyBird.controller.Controller;
import FlappyBird.controller.menu.HowToPlayController;
import FlappyBird.model.menu.HowToPlay;
import FlappyBird.viewer.Viewer;
import FlappyBird.viewer.menu.HowToPlayViewer;

public class HowToPlayState extends State<HowToPlay> {
    public HowToPlayState(HowToPlay model){ super(model);}

    @Override
    protected Viewer<HowToPlay> getViewer(){return new HowToPlayViewer(getModel());}

    @Override
    protected Controller<HowToPlay> getController(){
        return new HowToPlayController(getModel());
    }
}

