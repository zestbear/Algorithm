cnt = int(input())
lst = []

for i in range(cnt):
    num = input().split()
    a = int(num[0])
    b = int(num[1])

    minNum = min(a, b)
    maxNum = max(a, b)
    gcd = 0

    if minNum == 1:
        lst.append(maxNum)
    elif a == b:
        lst.append(a)
    else:
        for i in range(1, minNum + 1):
            if a % i == 0 and b % i == 0:
                gcd = i
        lst.append(int(a * b / gcd))

for i in lst:
    print(i)
