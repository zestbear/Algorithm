#include <stdio.h>
#define min(a,b)  (((a) < (b)) ? (a) : (b))

int main(){
    int N;
    scanf("%d",&N);
    int red[1000];
    int gre[1000];
    int blu[1000];
    for(int i=0;i<N;i++){
        scanf("%d %d %d",&red[i], &gre[i], &blu[i]);
    }

    int dp[1001][3];
    dp[0][0]=red[0];
    dp[0][1]=gre[0];
    dp[0][2]=blu[0];
    for(int i=1;i<1000;i++){
        dp[i][0] = min(dp[i-1][1], dp[i-1][2])+red[i];
        dp[i][1] = min(dp[i-1][0], dp[i-1][2])+gre[i];
        dp[i][2] = min(dp[i-1][0], dp[i-1][1])+blu[i];
    }
    int min=dp[N-1][0];
    for(int i=1;i<3;i++){
        if(dp[N-1][i]<min) min=dp[N-1][i];
    }
    printf("%d\n",min);

    return 0;
}