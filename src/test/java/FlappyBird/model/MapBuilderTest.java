package FlappyBird.model;

import FlappyBird.model.game.elements.Bird;
import FlappyBird.model.game.map.Map;
import FlappyBird.model.game.map.MapBuilder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MapBuilderTest {
    private Map map;
    private Bird bird;
    @BeforeEach
    void setUp() {
        map = new Map(40, 20);
        bird = new Bird(10, 10);
        map.setBird(bird);
    }

    @Test
    void createMap() {
        assertEquals(map.getBird().getPosition(), new MapBuilder(40, 20).createMap().getBird().getPosition());
        assertEquals(map.getHeight(), new MapBuilder(40, 20).createMap().getHeight());
        assertEquals(map.getWidth(), new MapBuilder(40, 20).createMap().getWidth());
    }
}
