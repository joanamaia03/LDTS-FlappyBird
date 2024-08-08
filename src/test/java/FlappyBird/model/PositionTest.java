package FlappyBird.model;

import net.jqwik.api.ForAll;
import net.jqwik.api.Property;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PositionTest {
    @Property
    void getJump(@ForAll int x, @ForAll int y) {
        assertEquals(x, new Position(x, y).getJump().getX());
        assertEquals(y-3, new Position(x, y).getJump().getY());
    }
    @Property
    void getFall(@ForAll int x, @ForAll int y) {
        assertEquals(x, new Position(x, y).getFall().getX());
        assertEquals(y+1, new Position(x, y).getFall().getY());
    }
    @Property
    void getCeiling(@ForAll int x, @ForAll int y) {
        assertEquals(x, new Position(x, y).getCeiling().getX());
        assertEquals(-1, new Position(x, y).getCeiling().getY());
    }
    @Property
    void getLeft(@ForAll int x, @ForAll int y) {
        assertEquals(x-1, new Position(x, y).getLeft().getX());
        assertEquals(y, new Position(x, y).getLeft().getY());
    }
}
