package FlappyBird.gui;

import FlappyBird.model.Position;

import java.io.IOException;

public interface GUI {
    ACTION getNextAction() throws IOException;
    int getWidth();
    int getHeight();
    void drawBackground();
    void drawBird(Position position);
    void drawPipe(Position position);
    void drawTextMenu(Position position, String text, String color);
    void drawTextGame(Position position, String text, String color);
    void clear();
    void refresh() throws IOException;
    void close() throws IOException;

    void drawScore(String text, String Color);

    enum ACTION {SPACE, NONE, QUIT, UP, DOWN, SELECT}
}
