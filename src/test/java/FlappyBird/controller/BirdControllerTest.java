package FlappyBird.controller;

import FlappyBird.controller.game.BirdController;
import FlappyBird.model.Position;
import FlappyBird.model.game.elements.Bird;
import FlappyBird.model.game.map.Map;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BirdControllerTest {
    private BirdController controller;
    private Bird bird;
    private Map map;

    @BeforeEach
    void setUp() {
        map = new Map(40,20);
        bird = new Bird(10,10);
        map.setBird(bird);
        controller = new BirdController(map);
    }

    @Test
    void moveBirdJumpEmpty() {
        controller.moveBirdJump();
        assertEquals(new Position(10, 7), bird.getPosition());
    }

    @Test
    void moveBirdJumpCeiling() {
        bird.setPosition(new Position(10, 0));
        controller.moveBirdJump();
        assertEquals(new Position(10,-1), bird.getPosition());
    }

    @Test
    void fall() {
        controller.fall();
        assertEquals(new Position(10, 11), bird.getPosition());
    }
}
