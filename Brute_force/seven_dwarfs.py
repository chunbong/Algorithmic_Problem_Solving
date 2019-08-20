# https://www.acmicpc.net/problem/2309

dwarfs = []
for _ in range(9):
    tall = int(input())
    dwarfs.append(tall)

sum = 0
for i in range(8):
    if sum == 100:
        break
    for j in range(i+1, 9):
        sum = 0
        result = []
        for k in range(9):
            if k == i or k == j:
                continue
            result.append(dwarfs[k])
            sum += dwarfs[k]
        if sum == 100:
            break

result.sort()
for i in range(len(result)):
    print(result[i])