import java.io.*;
import java.util.*;

class Main {

    static class Tree {
        public long[] tree;
        public int n;

        public Tree(long[] arr) {
            n = arr.length;
            tree = new long[4 * n];
            make(arr, 0, n - 1, 0);
//            print();
        }

        public void make(long[] arr, int start, int end, int node) {
            if (start == end) {
                tree[node] = arr[start];
            } else {
                int mid = (start + end) / 2;
                make(arr, start, mid, 2 * node + 1);
                make(arr, mid + 1, end, 2 * node + 2);
                tree[node] = tree[2 * node + 1] + tree[2 * node + 2];
            }
        }

        public void change(long idx, long value) {
            change(0, n - 1, idx - 1, value, 0);
//            print();
        }

        public void change(int start, int end, long idx, long value, int node) {
            if (start == end) {
                tree[node] = value;
            } else {
                int mid = (start + end) / 2;
                if (start <= idx && idx <= mid) {
                    change(start, mid, idx, value, 2 * node + 1);
                } else {
                    change(mid + 1, end, idx, value, 2 * node + 2);
                }
                tree[node] = tree[2 * node + 1] + tree[2 * node + 2];
            }
        }

        public long sum(long left, long right) {
            return sum(0, n - 1, left - 1, right - 1, 0);
        }

        public long sum(int start, int end, long left, long right, int node) {
            if (right < start || end < left) {
                return 0;
            }
            if (left <= start && end <= right) {
                return tree[node];
            }

            int mid = (start + end) / 2;
            long leftSum = sum(start, mid, left, right, 2 * node + 1);
            long rightSum = sum(mid + 1, end, left, right, 2 * node + 2);
            return leftSum + rightSum;
        }

        public void print() {
            for (int i = 0; i < n; i++) {
                System.out.print(tree[i] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        long[] arr = new long[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Long.parseLong(br.readLine());
        }
        Tree tree = new Tree(arr);

        for (int i = 0; i < M + K; i++) {
            st = new StringTokenizer(br.readLine());
            int fuc = Integer.parseInt(st.nextToken());
            long num1 = Long.parseLong(st.nextToken());
            long num2 = Long.parseLong(st.nextToken());

            if (fuc == 1) tree.change(num1, num2);
            else if(fuc == 2) System.out.println(tree.sum(num1, num2));
        }
    }
}
