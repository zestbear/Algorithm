#include <stdio.h>
#include <stdlib.h>

void hanoi(int start, int sub, int end, int n);
void move(int start, int end);

typedef struct term *node;
typedef struct term{
    int a;
    int b;
    node link;
};
node D;
int cnt=0;

int main(){
    int N;
    scanf("%d",&N);
    D=(node)malloc(sizeof(*D));
    D->a=0;
    D->b=0;
    D->link=NULL;
    hanoi(1,2,3,N);
    printf("%d\n",cnt);
    node k=D->link;
    while(k!=NULL){
        printf("%d %d",k->a,k->b);
        k=k->link;
        printf("\n");
    }

    return 0;
}

void hanoi(int start, int sub, int end, int n){
    if(n==1){
        move(start,end);
    }
    else{
        hanoi(start,end,sub,n-1);
        move(start,end);
        hanoi(sub,start,end,n-1);
    }
}
void move(int start, int end){
    node rear=D;
    while(rear->link!=NULL){
        rear=rear->link;
    }
    node newnode;
    newnode=(node)malloc(sizeof(*newnode));
    newnode->a=start;
    newnode->b=end;
    rear->link=newnode;
    cnt++;
}