class Solution {
    
    static int dm;
    static int dn;
    
    public static boolean check(int x, int y) {
        if(0<=x && x<dm && 0<=y && y<dn) return true;
        else return false;
    }
    
    public int solution(int m, int n, int[][] puddles) {
        dm = m; dn = n;
        int[][] dp = new int[m][n];
        dp[0][0] = 1;
        
        boolean[][] pud = new boolean[m][n];
        for(int i=0;i<puddles.length;i++){
            pud[puddles[i][0]-1][puddles[i][1]-1] = true;
        }
        
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(i==0 && j==0) continue;
                if(pud[i][j]) {
                    dp[i][j] = 0;
                    continue;
                }
                
                int nx=0;
                int ny=0;
                if(check(i-1,j)) nx=dp[i-1][j];
                if(check(i,j-1)) ny=dp[i][j-1];
                
                dp[i][j]=nx+ny;
                dp[i][j]%=1000000007;
            }
        }
        
        return dp[m-1][n-1];
    }
}