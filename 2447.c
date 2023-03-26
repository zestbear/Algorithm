#include <stdio.h>

void star(int x, int y, int n){
    if((x/n)%3==1 && (y/n)%3==1){
        printf(" ");
    }
    else{
        if(n/3==0) printf("*");
        else(star(x,y,n/3));
    }
}

int main(){
    int N;
    scanf("%d",&N);
    for(int i=0;i<N;i++){
        for(int j=0;j<N;j++){
            star(i, j, N);
        }
        printf("\n");
    }

    return 0;
}