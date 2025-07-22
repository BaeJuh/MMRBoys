public class Rotor {
    private static final String ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private String write;
    private int position;

    public Rotor(String write, char initPosition) {
        this.write = write;
        this.position = ALPHABET.indexOf(initPosition);
    }

    public char forward(char c) {
        int index = (ALPHABET.indexOf(c) + position) % ALPHABET.length();
        return ALPHABET.charAt(index);
    }

    public char backward(char c) {
        int index = write.indexOf(c);
        return ALPHABET.charAt((index - position + ALPHABET.length()) % ALPHABET.length());
    }

    public boolean rotate() {
        this.position = (this.position + 1) % ALPHABET.length();
        return position == 0;
    }

}
