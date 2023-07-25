
N=int(input())
dp=[0 for i in range(5001)]

for i in range(1,N+1):
    if i==1 or i==2:
        dp[i]=-1
    elif i==3 or i==5:
        dp[i]=1
    elif i%5==0:
        dp[i]=i/5
    else:
        if dp[i-3]!=-1:
            dp[i]=dp[i-3]+1
        else:
            dp[i]=-1

print(int(dp[i]))
