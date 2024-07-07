import java.io.*;
import java.util.*;

class Main {

    static class Node implements Comparable<Node> {
        int vertex;
        int cost;

        public Node(int vertex, int cost) {
            this.vertex = vertex;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.cost, o.cost);
        }
    }

    public static int[] dijkstra(int start, ArrayList<ArrayList<Node>> arr) {
        int len = arr.size();
        boolean[] visit = new boolean[len];
        int[] dist = new int[len];
        Arrays.fill(dist, Integer.MAX_VALUE);
        PriorityQueue<Node> queue = new PriorityQueue<>();
        queue.add(new Node(start, 0));
        dist[start] = 0;

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            int currVer = node.vertex;
            int currCost = node.cost;
            if(visit[currVer]) continue;
            visit[currVer] = true;
            for (Node next : arr.get(currVer)) {
                int nextVer = next.vertex;
                int nextCost = next.cost;
                if (dist[currVer] + nextCost < dist[nextVer]) {
                    dist[nextVer] = dist[currVer] + nextCost;
                    queue.add(new Node(nextVer, dist[nextVer]));
                }
            }
        }

        return dist;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(br.readLine());

        ArrayList<ArrayList<Node>> edges = new ArrayList<>();
        for (int i = 0; i < V + 1; i++) {
            edges.add(new ArrayList<>());
        }
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            boolean updated = false;
            for (Node node : edges.get(u)) {
                if (node.vertex == v) {
                    if (node.cost > w) {
                        node.cost = w;
                    }
                    updated = true;
                    break;
                }
            }
            if (!updated) {
                edges.get(u).add(new Node(v, w));
            }
        }

        int[] result = dijkstra(start, edges);
        for (int i = 1; i < result.length; i++) {
            if (result[i] == Integer.MAX_VALUE) {
                System.out.println("INF");
            } else {
                System.out.println(result[i]);
            }
        }
    }
}