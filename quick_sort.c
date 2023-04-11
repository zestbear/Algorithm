// 2-way

#include <stdio.h>

int main(void){
    int N;
    scanf("%d",&N);
    int arr[N];
    for(int i=0;i<N;i++){
        scanf("%d",&arr[i]);
    }
    
    int temp;
    for(int i=0;i<N/2-1;i++){
        for(int j=i+1;j<N/2;j++){
            if(arr[i]>arr[j]){
                temp=arr[i];
                arr[i]=arr[j];
                arr[j]=temp;
            }
        }
    }
    for(int i=N/2;i<N-1;i++){
        for(int j=i+1;j<N;j++){
            if(arr[i]>arr[j]){
                temp=arr[i];
                arr[i]=arr[j];
                arr[j]=temp;
            }
        }
    }
    
    int arg[N];
    int idx=0;
    int sp1=0, sp2=N/2;
    while(idx<N){
        if(arr[sp1]<arr[sp2]){
            arg[idx]=arr[sp1];
            sp1++;
            idx++;
        }
        else if(arr[sp1]>arr[sp2]){
            arg[idx]=arr[sp2];
            sp2++;
            idx++;
        }
        if(sp1==N/2){
            arg[idx]=arr[sp2];
            sp2++;
            idx++;
        }
        else if(sp2==N){
            arg[idx]=arr[sp1];
            sp1++;
            idx++;
        }
    }
    
    for(int i=0;i<N;i++){
        printf("%d ",arg[i]);
    }
    
    return 0;
}
