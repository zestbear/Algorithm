import java.util.*;


public class Main {

    public static void main(String[] args) {
        int N;
        int k;
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        k = sc.nextInt();

        ArrayList<Integer> list = new ArrayList<>();
        ArrayList[] in = new ArrayList[N + 1];
        for (int i = 1; i < N + 1; i++) {
            in[i] = new ArrayList<Integer>();
        }


        for (int i = 0; i < k; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            in[a].add(b);
            in[b].add(a);
        }

        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < in[1].size(); i++) {
            queue.add((int)in[1].get(i));
        }

        while (!queue.isEmpty()) {
            int idx = queue.poll();
            for (int i = 0; i < in[idx].size(); i++) {
                if (!list.contains((int) in[idx].get(i))) {
                    list.add((int) in[idx].get(i));
                    queue.add((int) in[idx].get(i));
                }
            }
        }

        System.out.println(list.size()==0 ? 0 : list.size() - 1);

        sc.close();

    }
}

/*
for (int i = 0; i < N; i++) {
            if (list[i].contains(1)) {
                System.out.println(list[i].size());
            }
        }


        for (int i = 0; i < N; i++) {
            System.out.println(list);
        }
 */

/*
12
10
1 2
3 4
5 6
1 7
2 8
3 9
10 4
11 5
8 9
12 8
 */