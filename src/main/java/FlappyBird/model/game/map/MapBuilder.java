package FlappyBird.model.game.map;

import FlappyBird.model.game.elements.Pipe;
import FlappyBird.model.game.elements.Bird;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MapBuilder {
    private final int width;
    private final int height;
    public MapBuilder(int width, int height) {
        this.width = width;
        this.height = height;
    }
    public Map createMap() {
        Map map = new Map(width, height);
        map.setBird(createBird());
        map.setPipes(createPipes());
        return map;
    }
    protected List<Pipe> createPipes() {
        int x = width;
        Random random = new Random();
        List<Pipe> pipes = new ArrayList<>();
        while(x < 11357) {
            int n = random.nextInt(height - 5) + 2;
            for (int c = -1; c < height-1; c++) {
                if ((n - 2 > c) || (c > n + 1)) {
                    pipes.add(new Pipe(x, c));
                    pipes.add(new Pipe(x - 1, c));
                }
            }
            x += (width / 2);
        }
        return pipes;
    }
    protected Bird createBird() {return new Bird(10,10);}
}
