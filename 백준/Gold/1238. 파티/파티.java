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

    public static int[] dijkstra(ArrayList<ArrayList<Node>> roads, int start) {
        PriorityQueue<Node> queue = new PriorityQueue<>();
        queue.add(new Node(start, 0));
        int[] dist = new int[roads.size()];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;
        boolean[] visit = new boolean[roads.size()];

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            int currentVertex = node.vertex;

            if (visit[currentVertex]) continue;
            visit[currentVertex] = true;

            for (Node next : roads.get(currentVertex)) {
                int nextVertex = next.vertex;
                int nextCost = next.cost;
                if (dist[nextVertex] > dist[currentVertex] + nextCost) {
                    dist[nextVertex] = dist[currentVertex] + nextCost;
                    queue.add(new Node(nextVertex, dist[nextVertex]));
                }
            }
        }
        return dist;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());

        ArrayList<ArrayList<Node>> roads = new ArrayList<>();
        for (int i = 0; i < N + 1; i++) {
            roads.add(new ArrayList<>());
        }

        for (int i = 1; i < M + 1; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            roads.get(start).add(new Node(end, cost));
        }

        int max = Integer.MIN_VALUE;
        int[] toHomeArr = dijkstra(roads, X);
        for (int i = 1; i < N + 1; i++) {
            int toParty = dijkstra(roads, i)[X];
            int toHome = toHomeArr[i];
            if (max < toParty + toHome) max = toParty + toHome;
        }
        System.out.println(max);
    }
}