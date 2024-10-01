class Solution {
    public int solution(int[][] triangle) {
        int answer = 0;
        int h = triangle.length;
        int[][] dp = new int[h][];
        for(int i=0;i<h;i++) dp[i] = new int[i+1];
        dp[0][0] = triangle[0][0];
        
        for(int i=0;i<h-1;i++){
            for(int j=0;j<i+1;j++){
                int s1 = triangle[i+1][j] + dp[i][j];
                int s2 = triangle[i+1][j+1] + dp[i][j];
                if(dp[i+1][j] < s1) dp[i+1][j] = s1;
                if(dp[i+1][j+1] < s2) dp[i+1][j+1] = s2;
            }
        }
        
        for(int i=0;i<h;i++){
            if(answer < dp[h-1][i]) answer = dp[h-1][i];
        }
        
        return answer;
    }
}