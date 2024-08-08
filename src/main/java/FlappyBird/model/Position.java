package FlappyBird.model;

import java.util.Objects;

public class Position {
    private final int x;
    private final int y;
    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }
    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }
    public Position getJump() {
        return new Position(x, y + -3);
    }
    public Position getFall() {
        return new Position(x, y + 1);
    }
    public Position getCeiling() {
        return new Position(x, -1);
    }
    public Position getLeft() {
        return new Position(x - 1, y);
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Position position = (Position) o;
        return x == position.x && y == position.y;
    }
    @Override
    public int hashCode() {
        return Objects.hash(x,y);
    }
}
