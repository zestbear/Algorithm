#include <stdio.h>

void Search(int DC[], int length, int find){
    int left[length/2];
    for(int i=0;i<length/2;i++){
        left[i]=DC[i];
    }
    int right[length-length/2];
    for(int i=0;i<length-length/2;i++){
        right[i]=DC[i+length/2];
    }
    
    if(find==DC[length/2]) printf("The finding number is in Array\n");
    else if(find>DC[length/2]) Search(right, (int)sizeof(right)/sizeof(int), find);
    else if(find<DC[length/2]) Search(left, (int)sizeof(left)/sizeof(int), find);
    else printf("The finding number is NOT in Array");
}

int main(void){
    int n;
    scanf("%d",&n);
    int arr[n];
    for(int i=0;i<n;i++){
        scanf("%d",&arr[i]);
    }
    int x;
    scanf("%d",&x);
    Search(arr, (int)sizeof(arr)/sizeof(int), x);
    printf("\n");
    
    return 0;
}

// 10 20 30 50 60 80 110 130 140 170
// n = 10
// x = 110
