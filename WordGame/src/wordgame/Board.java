package wordgame;

import java.util.*;

public class Board {
    private final List<String> words = new ArrayList<>();
    private final Map<String, Integer> scores = new HashMap<>();

    public synchronized void submitWord(String playerName, String word, int score) {
        words.add(word);
        scores.put(playerName, scores.getOrDefault(playerName, 0) + score);
        System.out.println(playerName + " submitted word: " + word + " (" + score + " pts)");
    }

    public synchronized Map<String, Integer> getFinalScores() {
        return new HashMap<>(scores);
    }
}
