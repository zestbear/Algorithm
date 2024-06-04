#include <stdio.h>
#include <math.h>

void hanoi(int start, int sub, int end, int n){
    if(n==1){
        printf("%d %d\n",start,end);
    }
    else{
        hanoi(start,end,sub,n-1);
        printf("%d %d\n",start,end);
        hanoi(sub,start,end,n-1);
    }
}

int main(){
    int N;
    scanf("%d",&N);
    int t=pow(2,N)-1;
    printf("%d\n",t);
    hanoi(1,2,3,N);
    return 0;
}