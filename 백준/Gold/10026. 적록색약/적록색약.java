import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static String[][] arr = new String[100][100];
    static String[][] ary = new String[100][100];
    static int[] groupCount = new int[3];
    static int[] groupCount_RG = new int[2];
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static String beforeValue;
    static String beforeValue_RG;

    public static void DFS(int row, int col) {
        String currentValue = arr[row][col];
        arr[row][col] = "O";
        for (int i = 0; i < 4; i++) {
            int nx = row + dx[i];
            int ny = col + dy[i];
            if (nx >= 0 && ny >= 0 && nx < 100 && ny < 100) {
                if (currentValue.equals(arr[nx][ny]) && !arr[nx][ny].equals("O") && !(arr[nx][ny]==null)) {
                    DFS(nx, ny);
                }
            }
        }
        if (beforeValue == null) {
        } else if (currentValue.equals(beforeValue)) {
            if (currentValue.equals("R")) {
                groupCount[0]--;
            } else if (currentValue.equals("G")) {
                groupCount[1]--;
            } else if (currentValue.equals("B")) {
                groupCount[2]--;
            }
        }
        if (currentValue.equals("R")) {
            groupCount[0]++;
        } else if (currentValue.equals("G")) {
            groupCount[1]++;
        } else if (currentValue.equals("B")) {
            groupCount[2]++;
        }
        beforeValue = currentValue;
    }

    public static void DFS_RG(int row, int col) {
        String currentValue_RG = ary[row][col];
        ary[row][col] = "O";
        for (int i = 0; i < 4; i++) {
            int nx = row + dx[i];
            int ny = col + dy[i];
            if (nx >= 0 && ny >= 0 && nx < 100 && ny < 100) {
                if (currentValue_RG.equals(ary[nx][ny]) && !ary[nx][ny].equals("O") && !(ary[nx][ny]==null)) {
                    DFS_RG(nx, ny);
                }
            }
        }
        if (beforeValue_RG == null) {
        } else if (currentValue_RG.equals(beforeValue_RG)) {
            if (currentValue_RG.equals("R")) {
                groupCount_RG[0]--;
            } else if (currentValue_RG.equals("B")) {
                groupCount_RG[1]--;
            }
        }
        if (currentValue_RG.equals("R")) {
            groupCount_RG[0]++;
        } else if (currentValue_RG.equals("B")) {
            groupCount_RG[1]++;
        }
        beforeValue_RG = currentValue_RG;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        for (int i = 0; i < N; i++) {
            String str = bf.readLine();
            String[] strs = str.split("");
            for (int j = 0; j < N; j++) {
                arr[i][j] = strs[j];
                if (strs[j].equals("G")) {
                    ary[i][j] = "R";
                } else {
                    ary[i][j] = strs[j];
                }
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                DFS(i, j);
                DFS_RG(i, j);
            }
        }

        int x = groupCount[0] + groupCount[1] + groupCount[2];
        int y = groupCount_RG[0] + groupCount_RG[1];
        System.out.println(x+" "+y);

        bf.close();
    }
}