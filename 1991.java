import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        ArrayList<Integer> arrayList = new ArrayList<>();
        int max = Collections.max(arrayList);

        int N = Integer.parseInt(br.readLine());
        String a, b, c;
        String[][] tree = new String[26][2];
        for (int i = 1; i < N + 1; i++) {
            st = new StringTokenizer(br.readLine());
            a = st.nextToken();
            b = st.nextToken();
            c = st.nextToken();
            int root = a.charAt(0) - 'A';
            if (!b.equals(".")) {
                tree[root][0] = b;
            } else {
                tree[root][0] = "";
            }
            if (!c.equals(".")) {
                tree[root][1] = c;
            } else {
                tree[root][1] = "";
            }
        }

        preorder(tree, 0);
        System.out.println();
        inorder(tree, 0);
        System.out.println();
        postorder(tree, 0);
        System.out.println();

        br.close();
    }

    public static void preorder(String[][] tree, int idx) {
        if (tree[idx][0] == null || tree[idx][1] == null) {
            return;
        }
        System.out.print((char) (idx + 'A'));
        if (!tree[idx][0].equals("")) {
            preorder(tree, tree[idx][0].charAt(0) - 'A');
        }
        if (!tree[idx][1].equals("")) {
            preorder(tree, tree[idx][1].charAt(0) - 'A');
        }
    }

    public static void inorder(String[][] tree, int idx) {
        if (tree[idx][0] == null || tree[idx][1] == null) {
            return;
        }
        if (!tree[idx][0].equals("")) {
            inorder(tree, tree[idx][0].charAt(0) - 'A');
        }
        System.out.print((char) (idx + 'A'));
        if (!tree[idx][1].equals("")) {
            inorder(tree, tree[idx][1].charAt(0) - 'A');
        }
    }

    public static void postorder(String[][] tree, int idx) {
        if (tree[idx][0] == null || tree[idx][1] == null) {
            return;
        }
        if (!tree[idx][0].equals("")) {
            postorder(tree, tree[idx][0].charAt(0) - 'A');
        }
        if (!tree[idx][1].equals("")) {
            postorder(tree, tree[idx][1].charAt(0) - 'A');
        }
        System.out.print((char) (idx + 'A'));
    }
}
