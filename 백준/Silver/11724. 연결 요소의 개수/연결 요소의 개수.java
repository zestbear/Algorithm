import java.util.*;
import java.io.*;

public class Main {

    static boolean[] visit; // 방문 여부
    static int[][] value; // 간선 정보 저장

    public static void dfs(int curr) { // dfs로 풀이
        if (visit[curr]) { // 방문한 적이 있는 노드라면 return,
            return;
        } else { // 방문한 적이 없는 노드라면 계속해서 dfs 호출
            visit[curr] = true;
            for (int i = 1; i < value.length; i++) {
                if (value[curr][i] == -1) {
                    dfs(i);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 입력
        String[] line;

        line = br.readLine().split(" ");
        int N = Integer.parseInt(line[0]);
        int M = Integer.parseInt(line[1]);

        visit = new boolean[N + 1];
        value = new int[N + 1][N + 1];
        for (int i = 0; i < M; i++) {
            String[] temp = br.readLine().split(" ");
            value[Integer.parseInt(temp[0])][Integer.parseInt(temp[1])] = -1; // 간선 정보가 존재한다는 것을
            value[Integer.parseInt(temp[1])][Integer.parseInt(temp[0])] = -1; // 양방향으로 표시
        }

        int result = 0;
        for (int i = 1; i < N + 1; i++) {
            if (!visit[i]) {
                dfs(i);
                result++;
            }
        }

        System.out.println(result);
        br.close();
    }
}
