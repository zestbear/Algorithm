
N=int(input())
arr=[[0 for j in range(2)] for i in range(N)]

for i in range(N):
    a, b = map(int, input().split())
    arr[i][0]=a
    arr[i][1]=b

arr.sort()

for i in range(N):
    print(arr[i][0], arr[i][1])