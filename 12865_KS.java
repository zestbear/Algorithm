import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main{

    public static int knapsack(int K, int Weight[], int Value[], int n){
        if(n==0 || K==0)
            return 0;
        if(Weight[n-1]>K)
            return knapsack(K, Weight, Value, n-1);
        else{
            return Math.max(Value[n-1]+knapsack(K-Weight[n-1],Weight , Value, n-1), knapsack(K, Weight, Value, n-1));
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] Weight = new int[N];
        int[] Value = new int[N];
        for(int i=0; i<N; i++){
           st = new StringTokenizer(bf.readLine());
            Weight[i] = Integer.parseInt(st.nextToken());
            Value[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(knapsack(K, Weight, Value, N));
    }
}