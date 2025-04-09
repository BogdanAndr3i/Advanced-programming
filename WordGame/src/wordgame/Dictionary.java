package wordgame;

import java.util.Set;

public class Dictionary {
    private final Set<String> words = Set.of("CAT", "DOG", "APPLE", "BEE", "CAR", "DO", "GO", "ME", "YOU");

    public boolean isValidWord(String word) {
        return words.contains(word.toUpperCase());
    }
}
