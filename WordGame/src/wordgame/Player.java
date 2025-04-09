package wordgame;

import java.util.*;

public class Player extends Thread {
    private final String name;
    private final Bag bag;
    private final Board board;
    private final Dictionary dictionary;
    private final Random rand = new Random();

    public Player(String name, Bag bag, Board board, Dictionary dictionary) {
        this.name = name;
        this.bag = bag;
        this.board = board;
        this.dictionary = dictionary;
    }

    @Override
    public void run() {
        while (!bag.isEmpty()) {
            List<Tile> hand = bag.extractTiles(7);
            if (hand.isEmpty()) break;

            String word = findValidWord(hand);

            if (word != null) {
                int score = calculateScore(word, hand);
                board.submitWord(name, word, score);

                bag.extractTiles(word.length());
            } else {
                System.out.println(name + " could not form a valid word, discarded tiles.");
            }

            try {
                Thread.sleep(rand.nextInt(500));
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }

    private String findValidWord(List<Tile> hand) {
        List<String> allCombinations = generateCombinations(hand);

        for (String candidate : allCombinations) {
            if (dictionary.isValidWord(candidate)) {
                return candidate;
            }
        }
        return null;
    }

    private List<String> generateCombinations(List<Tile> hand) {
        List<String> combinations = new ArrayList<>();
        char[] letters = new char[hand.size()];
        for (int i = 0; i < hand.size(); i++) {
            letters[i] = hand.get(i).letter;
        }

        for (int len = 2; len <= letters.length; len++) {
            permute(letters, 0, len, combinations);
        }

        return combinations;
    }

    private void permute(char[] arr, int l, int len, List<String> result) {
        if (l == len) {
            result.add(new String(arr, 0, len));
            return;
        }

        for (int i = l; i < arr.length; i++) {
            swap(arr, l, i);
            permute(arr, l + 1, len, result);
            swap(arr, l, i);
        }
    }

    private void swap(char[] arr, int i, int j) {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private int calculateScore(String word, List<Tile> hand) {
        int score = 0;
        List<Tile> used = new ArrayList<>(hand);
        for (char c : word.toCharArray()) {
            for (Tile t : used) {
                if (t.letter == c) {
                    score += t.points;
                    used.remove(t);
                    break;
                }
            }
        }
        return score;
    }
}
