package FlappyBird.model.game.map;

import FlappyBird.model.Position;
import FlappyBird.model.game.elements.Bird;
import FlappyBird.model.game.elements.Pipe;

import java.util.List;

import static java.lang.Integer.MIN_VALUE;

public class Map {
    private final int width;
    private final int height;
    private List<Pipe> pipes;
    private Bird bird;
    public int getWidth() {
        return width;
    }
    public int getHeight() {
        return height;
    }
    public Bird getBird() {return bird;}
    public void setBird(Bird bird) {this.bird = bird;}
    public List<Pipe> getPipes() {return pipes;}
    public void setPipes(List<Pipe> pipes) {this.pipes = pipes;}
    public boolean isPipe(Position position) {
        for (Pipe pipe : pipes) if (pipe.getPosition().equals(position)) return true;
        return false;
    }

    public String getScore(){
        int score=0;
        int xcomp = MIN_VALUE;
        for (Pipe pipe: pipes){
            if (pipe.getPosition().getX()> xcomp && pipe.getPosition().getX()<10){
                xcomp = pipe.getPosition().getX() +1;
                score ++;
            }
        }
        return String.valueOf(score);
    }

    public boolean isGround(Position position) {
        if (height == position.getY()) return true;
        return false;
    }
    public boolean isCeiling(Position position) {
        if (0 >= position.getY()) return true;
        return false;
    }
    public Map(int width, int height){
        this.width = width;
        this.height = height;
    }
}