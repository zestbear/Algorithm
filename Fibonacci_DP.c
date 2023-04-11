#include <stdio.h>

int main(void){
    int N;
    scanf("%d",&N);
    int dp[N];
    dp[0]=0;
    dp[1]=1;
    for(int i=2;i<N+1;i++){
        dp[i]=dp[i-2]+dp[i-1];
    }
    
    printf("%d\n",dp[N]);
    
    return 0;
}
