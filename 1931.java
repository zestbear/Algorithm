import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        ArrayList<Integer> keys = new ArrayList<>();
        int N = Integer.parseInt(bf.readLine());
        int[][] time = new int[N][2];
        int a, b;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(bf.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            time[i][0] = a;
            time[i][1] = b;
            if(!map.containsKey(b)) {
                map.put(b, new ArrayList<>());
            }
            map.get(b).add(a);
        }

        int cnt = 0;
        int prev = 0;
        for(int i : map.keySet())
            keys.add(i);
        Collections.sort(keys);

        for(int i : keys) {
            Collections.sort(map.get(i));
            for(int j : map.get(i)) {
                if(j >= prev) {
                    prev = i;
                    cnt++;
                }
            }
        }
        System.out.println(cnt);
    }
}