cnt = int(input())
output = 0

for i in range(cnt):
    stack = []
    string = input()
    for j in range(len(string)):
        if string[j] in stack:
            if string[j - 1] != string[j]:
                break
        else:
            stack.append(string[j])
        if j == len(string) - 1:
            output += 1

print(output)