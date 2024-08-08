package FlappyBird.model.game.elements;

public class Pipe extends Element{
    public Pipe(int x, int y) {super(x,y);}
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        if (this.getClass() != o.getClass()) return false;
        return this.getPosition().equals(((Pipe) o).getPosition());
    }
}
