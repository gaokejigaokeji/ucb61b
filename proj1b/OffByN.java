public class OffByN implements CharacterComparator {
    private int n;

    public OffByN(int nnn) {
        n = nnn;
    }

    @Override
    public boolean equalChars(char x, char y) {
        return (Math.abs((int) x - (int) y) == n);
    }
}
