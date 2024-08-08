package FlappyBird.model.menu;

import java.util.Arrays;
import java.util.List;

public class HowToPlay {
    private final List<String> entries;
    public HowToPlay() {this.entries = Arrays.asList("Back");}
    public String getEntry(int i){
        return entries.get(i);
    }
}
