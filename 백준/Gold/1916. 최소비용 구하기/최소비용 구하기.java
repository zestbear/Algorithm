import java.io.*;
import java.util.*;

class Main {

    static class Node implements Comparable<Node> {
        int ver;
        int cost;

        Node(int ver, int cost) {
            this.ver = ver;
            this.cost = cost;
        }

        public int compareTo(Node o) {
            return Integer.compare(this.cost, o.cost);
        }
    }

    public static int dijkstra(int start, int end, ArrayList<ArrayList<Node>> input) {
        int len = input.size();
        int[] dist = new int[len];
        Arrays.fill(dist, Integer.MAX_VALUE);
        boolean[] visit = new boolean[len];
        Queue<Node> queue = new PriorityQueue<>();
        queue.add(new Node(start, 0));
        dist[start] = 0;

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            if(dist[node.ver] < node.cost) continue;
            visit[node.ver] = true;

            for (Node next : input.get(node.ver)) {
                if (dist[next.ver] > dist[node.ver] + next.cost) {
                    dist[next.ver] = dist[node.ver] + next.cost;
                    queue.add(next);
                }
            }
        }

        return dist[end];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        ArrayList<ArrayList<Node>> input = new ArrayList<>();
        for (int i = 0; i < n + 1; i++) input.add(new ArrayList<>());
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int src = Integer.parseInt(st.nextToken());
            int dst = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            input.get(src).add(new Node(dst, cost));
        }

        st = new StringTokenizer(br.readLine());
        int src = Integer.parseInt(st.nextToken());
        int dst = Integer.parseInt(st.nextToken());

        System.out.println(dijkstra(src, dst, input));
    }
}