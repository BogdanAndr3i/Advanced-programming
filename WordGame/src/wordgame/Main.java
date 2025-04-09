package wordgame;

import java.util.List;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Bag bag = new Bag();
        Board board = new Board();
        Dictionary dictionary = new Dictionary();

        List<Player> players = List.of(
                new Player("Alice", bag, board, dictionary),
                new Player("Bob", bag, board, dictionary),
                new Player("Charlie", bag, board, dictionary)
        );

        for (Player p : players) {
            p.start();
        }

        for (Player p : players) {
            p.join();
        }

        System.out.println("\n--- Final Scores ---");
        board.getFinalScores().forEach((name, score) ->
                System.out.println(name + ": " + score + " points"));
    }
}
