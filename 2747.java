import java.util.Scanner;

public class practice{

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        if(N>=45 || N<1) System.exit(0);
        int[] dp=new int[44];
        dp[0]=0;
        dp[1]=1;
        for(int i=2;i<44;i++){
            dp[i]=dp[i-2]+dp[i-1];
        }
        System.out.println(dp[N]);

        sc.close();
    }
}