import java.util.HashMap;
import java.util.Map;

public class Reflector {
    private static final String ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private Map<Character, Character> mapping = new HashMap<Character, Character>();

    public Reflector(String write) {
        for (int i = 0; i < write.length(); i++) {
            char c1 = ALPHABET.charAt(i);
            char c2 = write.charAt(i);
            mapping.put(c1, c2);
        }
    }

    public char getValue(char c) {
        return mapping.getOrDefault(c, c);
    }
}
