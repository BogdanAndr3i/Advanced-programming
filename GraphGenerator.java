import java.util.*;

public class GraphGenerator {
    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("nr agrumente trebuie sa fie > 2, n k");
            return;
        }

        int n = Integer.parseInt(args[0]);
        int k = Integer.parseInt(args[1]);

        if (n < k) {
            System.out.println("obligatoriu n >= k");
            return;
        }

        long startTime = System.nanoTime();
        int[][] matriceAdj = generareRandom(n, k);
        afisajMatrice(matriceAdj);

        int muchii = numarEdg(matriceAdj);
        System.out.println("Nr muchii: " + muchii);

        int[] deg = calcDeg(matriceAdj);
        int maxDegree = Arrays.stream(deg).max().getAsInt();
        int minDegree = Arrays.stream(deg).min().getAsInt();
        System.out.println("grad max: " + maxDegree);
        System.out.println("grad min: " + minDegree);

        int sumaGrd = Arrays.stream(deg).sum();
        if (sumaGrd == 2 * muchii) {
            System.out.println("suma grade corecta: " + sumaGrd + " = 2 * " + muchii);
        } else {
            System.out.println("eroare suma grade!");
        }

        if (n > 30000) {
            long endTime = System.nanoTime();
            long delta = (endTime - startTime) / 1000000; // Convert to milliseconds
            System.out.println("timp rulare pentru un n mare: " + delta + " ms");
        }
    }

    public static int[][] generareRandom(int n, int k) {
        int[][] graph = new int[n][n];

        Random rand = new Random();

        for (int i = 0; i < k; i++) {
            for (int j = i + 1; j < k; j++) {
                graph[i][j] = 1;
                graph[j][i] = 1;
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (rand.nextBoolean() && (graph[i][j] == 0)) {
                    graph[i][j] = 1;
                    graph[j][i] = 1;
                }
            }
        }

        return graph;
    }

    public static void afisajMatrice(int[][] matrix) {
        System.out.println("Matrice adiacenta:");
        for (int[] row : matrix) {
            for (int cell : row) {
                System.out.print(cell + " ");
            }
            System.out.println();
        }
    }

    public static int numarEdg(int[][] matrix) {
        int count = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = i + 1; j < matrix[i].length; j++) {
                if (matrix[i][j] == 1) {
                    count++;
                }
            }
        }
        return count;
    }

    public static int[] calcDeg(int[][] matrix) {
        int[] degrees = new int[matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 1) {
                    degrees[i]++;
                }
            }
        }
        return degrees;
    }
}
