package wordgame;

import java.util.*;

public class Bag {
    private final List<Tile> tiles = new ArrayList<>();
    private final Random rand = new Random();

    public Bag() {
        for (char c = 'A'; c <= 'Z'; c++) {
            for (int i = 0; i < 10; i++) {
                tiles.add(new Tile(c, rand.nextInt(10) + 1));
            }
        }
        Collections.shuffle(tiles);
    }

    public synchronized List<Tile> extractTiles(int k) {
        List<Tile> result = new ArrayList<>();
        for (int i = 0; i < k && !tiles.isEmpty(); i++) {
            result.add(tiles.remove(0));
        }
        return result;
    }

    public synchronized boolean isEmpty() {
        return tiles.isEmpty();
    }
}
