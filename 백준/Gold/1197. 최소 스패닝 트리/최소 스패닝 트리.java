import java.io.*;
import java.util.*;

public class Main {
    static int sum;
    static List<Point>[] list;
    static boolean[] visited;

    static class Point implements Comparable<Point>{
        int key;
        int value;

        public Point(int key, int value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public int compareTo(Point o) {
            return this.value - o.value;
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int v = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());

        list = new ArrayList[v+1];
        visited = new boolean[v+1];
        for(int i=1; i<v+1; i++) {
            list[i] = new ArrayList<>();
        }

        for(int i=0; i<e; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            list[a].add(new Point(b,w));
            list[b].add(new Point(a,w));
        }

        prim(1);
        System.out.println(sum);
    }

    static void prim(int start) {
        Queue<Point> queue = new PriorityQueue<>();

        queue.add(new Point(start, 0));
        while(!queue.isEmpty()) {
            Point p = queue.poll();
            int point = p.key;
            int weight = p.value;

            if(visited[point]) continue;
            visited[point]= true;
            sum += weight;

            for(Point next : list[point]) {
                if(!visited[next.key]) {
                    queue.add(next);
                }
            }
        }
    }
}