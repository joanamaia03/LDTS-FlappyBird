package FlappyBird.model.game.elements;

import FlappyBird.model.Position;

public class Element {
    private Position position;
    public Element(int x, int y) {
        position = new Position(x,y);
    }
    public Position getPosition() {
        return position;
    }
    public void setPosition(Position position) {
        this.position = position;
    }
}

