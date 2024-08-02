import java.io.*;
import java.util.*;

class Main {

    static Set<Integer> set = new HashSet<>();
    static StringBuilder sb = new StringBuilder();

    public static void add(int x) {
        set.add(x);
    }

    public static void remove(int x) {
        set.remove(x);
    }

    public static void check(int x) {
        if (set.contains(x)) {
            sb.append(1).append("\n");
        } else {
            sb.append(0).append("\n");
        }
    }

    public static void toggle(int x) {
        if (set.contains(x)) {
            set.remove(x);
        } else {
            set.add(x);
        }
    }

    public static void all() {
        set.clear();
        for (int i = 1; i < 21; i++) {
            set.add(i);
        }
    }

    public static void empty() {
        set.clear();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String input = st.nextToken();
            if (st.hasMoreTokens()) {
                int x = Integer.parseInt(st.nextToken());

                switch(input) {
                    case "add":
                        add(x); break;
                    case "remove":
                        remove(x); break;
                    case "check":
                        check(x); break;
                    case "toggle":
                        toggle(x); break;
                }
            }

            if (input.equals("all")) {
                all();
            } else if (input.equals("empty")) {
                empty();
            }
        }

        System.out.print(sb.toString());
    }
}