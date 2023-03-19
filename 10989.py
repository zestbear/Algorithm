N = int(input())
if N > 1000000 or N < 1:
    exit(0)
lst = list()
for i in range(N):
    num = int(input())
    lst.append(num)
for i in sorted(lst):
    print(i)