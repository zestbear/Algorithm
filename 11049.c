#include <stdio.h>

int main(void){
    int N;
    scanf("%d",&N);
    if(N>500 || N<0) return 0;
    
    int dp[N][2];
    for(int i=0;i<N;i++){
        dp[i][0]=0;
        dp[i][1]=0;
    }

    for(int i=0;i<N;i++){
        scanf("%d %d",&dp[i][0],&dp[i][1]);
        if(i>0 && dp[i][0]!=dp[i-1][1]) return 0;
    }
    
    
    
    return 0;
}
