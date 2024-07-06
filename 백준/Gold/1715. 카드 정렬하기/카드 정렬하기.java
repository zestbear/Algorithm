import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int i = 0; i < N; i++) {
            queue.add(Integer.parseInt(br.readLine()));
        }

        long sum = 0;
        while (!(queue.size() == 1)) {
            int fir = queue.poll();
            int sec = queue.poll();
            queue.add(fir + sec);
            sum += fir + sec;
        }
        System.out.println(sum);
    }
}