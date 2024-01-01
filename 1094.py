has = [64]


def addAll():
    sum = 0
    for i in has:
        sum = sum + i
    return sum


num = int(input())
while addAll() > num:
    temp = min(has)
    has.remove(temp)
    has.append(temp / 2)
    if addAll() < num:
        has.append(temp / 2)

print(len(has))
# print(bin(int(input())).count('1'))
