import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < T; i++) {
            String p = br.readLine();
            int n = Integer.parseInt(br.readLine());
            Deque<Integer> deq = new LinkedList<Integer>();
            boolean isReverse = false;
            int error = 0;

            StringTokenizer st = new StringTokenizer(br.readLine(), "[,]");
            for(int j = 1; j < (n * 2); j += 2) {
                deq.offer(Integer.parseInt(st.nextToken()));
            }

            for(int j = 0; j < p.length(); j++) {
                if(p.charAt(j) == 'R') {
                    if(isReverse) isReverse = false;
                    else isReverse = true;
                } else {
                    if(deq.isEmpty()) {
                        error = 1;
                        break;
                    }
                    if(isReverse == false) deq.pollFirst();
                    else deq.pollLast();
                }
            }

            if(error == 1) sb.append("error").append("\n");
            else {
                if(isReverse == true) {
                    sb.append("[");
                    while(!deq.isEmpty()) {
                        sb.append(deq.pollLast());
                        if(deq.isEmpty()) break;
                        sb.append(",");
                    }
                    sb.append("]").append("\n");
                }else {
                    sb.append("[");
                    while(!deq.isEmpty()) {
                        sb.append(deq.pollFirst());
                        if(deq.isEmpty()) break;
                        sb.append(",");
                    }
                    sb.append("]").append("\n");
                }
            }
        }
        System.out.println(sb);
    }

}