import java.util.HashMap;
import java.util.Map;

public class PlugBoard {
    private static final String ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private Map<Character, Character> mapping = new HashMap<Character, Character>();

    public PlugBoard() {
        for (char c : ALPHABET.toCharArray()) {
            mapping.put(c, c);
        }
    }

    public void connect(char c1, char c2) {
        this.mapping.put(c1, c2);
        this.mapping.put(c2, c1);
    }

    public char getValue(char c) {
        return mapping.getOrDefault(c, c);
    }
}
