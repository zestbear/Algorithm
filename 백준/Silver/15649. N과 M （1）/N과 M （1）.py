N,M=input().split()
N=int(N)
M=int(M)

arr=[]
def back():
    if len(arr) == M:
        for j in range(M):
            print(arr[j], end=" ")
        print()
        return
    for i in range(1,N+1):
        if i not in arr:
            arr.append(i)
            back()
            arr.pop()

back()