N, M = input().split()
N = int(N)
M = int(M)
arr = [[0 for j in range(M + 2)] for i in range(N + 2)]

for i in range(N):
    str = input()
    list(str)
    for j in range(M):
        arr[i + 1][j + 1] = int(str[j])

stack_x = [1]
stack_y = [1]
stack_dir = [0]

x = 1
y = 1
n = 0
# 반 시계 방향으로 ⬇️➡️⬆️⬅️
# 각각 1, 2, 3, 4로 저장
while x != N or y != M:
    if arr[x + 1][y] == 1 or n == 2:
        print("Case 1\n")
        stack_x.append(x)
        stack_y.append(y)
        stack_dir.append(1)
        for i in stack_x:
            print(i, end=" ")
        print()
        for i in stack_y:
            print(i, end=" ")
        print()
        for i in stack_dir:
            print(i, end=" ")
        print()
        print()
        x += 1
        continue
    if arr[x][y + 1] == 1 or n == 1:
        print("Case 2\n")
        stack_x.append(x)
        stack_y.append(y)
        stack_dir.append(2)
        for i in stack_x:
            print(i, end=" ")
        print()
        for i in stack_y:
            print(i, end=" ")
        print()
        for i in stack_dir:
            print(i, end=" ")
        print()
        print()
        y += 1
        continue
    if arr[x - 1][y] == 1 or n == 4:
        print("Case 3\n")
        if stack_x[len(stack_x)-1]==x-1 and stack_y[len(stack_y)-1]==y:
            continue
        stack_x.append(x)
        stack_y.append(y)
        stack_dir.append(3)
        for i in stack_x:
            print(i, end=" ")
        print()
        for i in stack_y:
            print(i, end=" ")
        print()
        for i in stack_dir:
            print(i, end=" ")
        print()
        print()
        x -= 1
        continue
    if arr[x][y - 1] == 1 or n == 3:
        print("Case 4\n")
        stack_x.append(x)
        stack_y.append(y)
        stack_dir.append(4)
        for i in stack_x:
            print(i, end=" ")
        print()
        for i in stack_y:
            print(i, end=" ")
        print()
        for i in stack_dir:
            print(i, end=" ")
        print()
        print()
        y -= 1
        continue
    else:
        bk_dir = stack_dir.pop()
        bk_x = stack_x.pop()
        bk_y = stack_y.pop()
        if bk_dir == 1:
            x = bk_x
            y = bk_y
            n = 2
        elif bk_dir == 2:
            x = bk_x
            y = bk_y
            n = 3
        elif bk_dir == 3:
            x = bk_x
            y = bk_y
            n = 4
        elif bk_dir == 4:
            x = stack_x.pop()
            y = stack_y.pop()
            n = stack_dir.pop()


print("END")
