#include <stdio.h>

//printf("%d\n",sizeof(arr[0])/sizeof(int)); 가로
//printf("%d\n",sizeof(arr)/sizeof(arr[0])); 세로

int main(){
    int M,N;
    scanf("%d %d",&M,&N);
    int arr[N+2][M+2];

    for(int i=1;i<N+1;i++){
        for(int j=1;j<M+1;j++){
            scanf("%d",&arr[i][j]);
        }
    }
    for(int i=0;i<N+2;i++){
        for(int j=0;j<M+2;j++){
            if(i==0 || j==0 || i==N+1 || j==M+1){
                arr[i][j]=-1;
            }
        }
    }

    int idx=0;
    while(1){
        int zero=0;
        int cnt=0;
        for(int i=1;i<N+1;i++){
            for(int j=1;j<M+1;j++){
                if(arr[i][j]==1){
                    if(arr[i+1][j]==0) {
                        arr[i + 1][j] = 2;
                        cnt++;
                    }
                    if(arr[i-1][j]==0) {
                        arr[i - 1][j] = 2;
                        cnt++;
                    }
                    if(arr[i][j+1]==0) {
                        arr[i][j + 1] = 2;
                        cnt++;
                    }
                    if(arr[i][j-1]==0) {
                        arr[i][j - 1] = 2;
                        cnt++;
                    }
                }
            }
        }
        for(int i=0;i<N+2;i++){
            for(int j=0;j<M+2;j++){
                if(arr[i][j]==2){
                    arr[i][j]=1;
                }
            }
        }
        for(int i=0;i<N+2;i++){
            for(int j=0;j<M+2;j++){
                if(arr[i][j]==0){
                    zero++;
                }
            }
        }
        if(cnt==0 && zero==0){
            break;
        }
        else if(cnt==0 && zero!=0){
            printf("-1");
            return 0;
        }
        else{
            idx++;
        }
    }
    printf("%d\n",idx);

    return 0;
}