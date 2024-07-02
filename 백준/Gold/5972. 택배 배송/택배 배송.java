import java.io.*;
import java.util.*;

class Main {

    static class Node implements Comparable<Node> {
        int ver;
        int cost;

        public Node(int ver, int cost) {
            this.ver = ver;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.cost, o.cost);
        }
    }

    public static int dijkstra(ArrayList<ArrayList<Node>> graph, int N) {
        boolean[] visit = new boolean[N + 1];
        int[] dist = new int[N + 1];
        int INF = Integer.MAX_VALUE;
        Arrays.fill(dist, INF);
        dist[1] = 0;

        PriorityQueue<Node> queue = new PriorityQueue<>();
        queue.add(new Node(1, 0));

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            int currNode = node.ver;

            if (visit[currNode]) continue;
            visit[currNode] = true;

            for (Node neighbor : graph.get(currNode)) {
                if (dist[currNode] + neighbor.cost < dist[neighbor.ver]) {
                    dist[neighbor.ver] = dist[currNode] + neighbor.cost;
                    queue.add(new Node(neighbor.ver, dist[neighbor.ver]));
                }
            }
        }

        return dist[N];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        ArrayList<ArrayList<Node>> graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            graph.get(u).add(new Node(v, w));
            graph.get(v).add(new Node(u, w));
        }

        System.out.println(dijkstra(graph, N));
    }
}
