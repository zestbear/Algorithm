import java.util.Scanner;

public class Main {
    private int[] queens;
    private int count;
    private int n;

    public int totalNQueens() {
        queens = new int[n];
        count = 0;
        placeQueens(0);
        return count;
    }

    private void placeQueens(int row) {
        if (row == n) {
            count++;
        } else {
            for (int col = 0; col < n; col++) {
                if (isValidPosition(row, col)) {
                    queens[row] = col;
                    placeQueens(row + 1);
                }
            }
        }
    }

    private boolean isValidPosition(int row, int col) {
        for (int i = 0; i < row; i++) {
            if (queens[i] == col || queens[i] - col == i - row || queens[i] - col == row - i) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Main nQueens = new Main();
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        nQueens.n = k;
        int count = nQueens.totalNQueens();
        System.out.println(count);
    }
}
