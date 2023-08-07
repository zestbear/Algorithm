N=int(input())

def han():
    idx=0
    if N<100:
        idx=N
    elif 100<=N<=1000:
        for i in range(100, N+1):
            a = i // 100
            b = (i % 100) // 10
            c = (i % 100) % 10
            if a-b == b-c:
                idx += 1
        idx=idx+99
    return idx

print(han())