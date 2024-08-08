package FlappyBird.gui;

import FlappyBird.model.Position;
import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;

import java.io.IOException;

public class LanternaGUI implements GUI {
    private final int width;
    private final int height;
    private final Screen screen;
    public LanternaGUI(Screen screen){
        this.width = 40;
        this.height = 20;
        this.screen = screen;
    }
    public LanternaGUI(int width, int height) throws IOException {
        this.width = width;
        this.height = height;
        Terminal terminal = createTerminal(width, height);
        this.screen = createScreen(terminal);
    }
    public int getWidth() {return width;}
    public int getHeight() {return height;}
    private Screen createScreen(Terminal terminal) throws IOException {
        final Screen screen;
        screen = new TerminalScreen(terminal);
        screen.setCursorPosition(null);
        screen.startScreen();
        screen.doResizeIfNecessary();
        return screen;
    }
    private Terminal createTerminal(int width, int height) throws IOException {
        TerminalSize terminalSize = new TerminalSize(width, height);
        DefaultTerminalFactory terminalFactory = new DefaultTerminalFactory().setInitialTerminalSize(terminalSize);
        Terminal terminal = terminalFactory.createTerminal();
        return terminal;
    }
    public ACTION getNextAction() throws IOException {
        KeyStroke key = screen.pollInput();
        if (key == null) return ACTION.NONE;
        if (key.getKeyType() == KeyType.EOF) return ACTION.QUIT;
        if (key.getKeyType() == KeyType.Character && key.getCharacter() == 'q') return ACTION.QUIT;
        if (key.getKeyType() == KeyType.Character && key.getCharacter() == ' ') return ACTION.SPACE;
        if (key.getKeyType() == KeyType.ArrowUp) return ACTION.UP;
        if (key.getKeyType() == KeyType.ArrowDown) return ACTION.DOWN;
        if (key.getKeyType() == KeyType.Enter) return ACTION.SELECT;
        return ACTION.NONE;
    }
    @Override
    public void drawBackground() {
        TextGraphics graphics = screen.newTextGraphics();
        graphics.setBackgroundColor(TextColor.Factory.fromString("#37C6FF"));
        graphics.fillRectangle(new TerminalPosition(0, 0), new TerminalSize(width, height), ' ');
    }
    @Override
    public void drawBird(Position position) {
        drawCharacter(position.getX(), position.getY(), 'V', "#ffff00", "#37C6FF");
    }
    @Override
    public void drawPipe(Position position) {
        drawCharacter(position.getX(), position.getY(), ' ', "#03AC13", "#03AC13");
    }
    @Override
    public void drawTextMenu(Position position, String text, String color) {
        TextGraphics graphics = screen.newTextGraphics();
        graphics.setBackgroundColor(TextColor.Factory.fromString("#37C6FF"));
        graphics.setForegroundColor(TextColor.Factory.fromString(color));
        graphics.putString(position.getX(), position.getY(), text, SGR.BOLD);
    }
    public void drawScore(String text, String color){
        TextGraphics graphics = screen.newTextGraphics();
        graphics.setBackgroundColor(TextColor.Factory.fromString("#37C6FF"));
        graphics.setForegroundColor(TextColor.Factory.fromString(color));
        graphics.putString(width/2-1, 2, text, SGR.BOLD);
    }
    public void drawTextGame(Position position, String text, String color) {
        TextGraphics graphics = screen.newTextGraphics();
        graphics.setBackgroundColor(TextColor.Factory.fromString("#37C6FF"));
        graphics.setForegroundColor(TextColor.Factory.fromString(color));
        graphics.putString(position.getX(), position.getY(), text, SGR.BOLD, SGR.BLINK);
    }
    private void drawCharacter(int x, int y, char c, String colorF, String colorB) {
        TextGraphics graphics = screen.newTextGraphics();
        graphics.setBackgroundColor(TextColor.Factory.fromString(colorB));
        graphics.setForegroundColor(TextColor.Factory.fromString(colorF));
        graphics.putString(x, y + 1, "" + c, SGR.BOLD);
    }
    @Override
    public void clear() {
        screen.clear();
    }
    @Override
    public void refresh() throws IOException {
        screen.refresh();
    }
    @Override
    public void close() throws IOException {
        screen.close();
    }
}
