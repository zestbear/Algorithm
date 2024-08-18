import java.io.*;
import java.util.*;

class Main {

    public static int[] count(boolean[][] arr) {
        if (check(arr)) {
            if(arr[0][0]) return new int[]{0, 1};
            else return new int[]{1, 0};
        } else {
            int[] sub1 = count(subArray(arr, 1));
            int[] sub2 = count(subArray(arr, 2));
            int[] sub3 = count(subArray(arr, 3));
            int[] sub4 = count(subArray(arr, 4));
            return new int[]{sub1[0] + sub2[0] + sub3[0] + sub4[0], sub1[1] + sub2[1] + sub3[1] + sub4[1]};
        }
    }

    public static boolean[][] subArray(boolean[][] arr, int n) {
        int length = arr.length;
        boolean[][] result = new boolean[length / 2][length / 2];
        if (n == 1) {
            for (int i = 0; i < length / 2; i++) {
                for (int j = 0; j < length / 2; j++) {
                    result[i][j] = arr[i][j];
                }
            }
        } else if (n == 2) {
            for (int i = 0; i < length / 2; i++) {
                for (int j = 0; j < length / 2; j++) {
                    result[i][j] = arr[i][length / 2 + j];
                }
            }
        } else if (n == 3) {
            for (int i = 0; i < length / 2; i++) {
                for (int j = 0; j < length / 2; j++) {
                    result[i][j] = arr[length / 2 + i][j];
                }
            }
        } else { // n == 4
            for (int i = 0; i < length / 2; i++) {
                for (int j = 0; j < length / 2; j++) {
                    result[i][j] = arr[length / 2 + i][length / 2 + j];
                }
            }
        }

        return result;
    }

    public static boolean check(boolean[][] arr) {
        int length = arr.length;
        boolean c = arr[0][0];
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                if(arr[i][j] != c) return false;
            }
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        boolean[][] arr = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                int input = Integer.parseInt(st.nextToken());
                if(input == 1) arr[i][j] = true;
                else arr[i][j] = false;
            }
        }

        int[] result = count(arr);
        System.out.println(result[0]);
        System.out.println(result[1]);
    }
}