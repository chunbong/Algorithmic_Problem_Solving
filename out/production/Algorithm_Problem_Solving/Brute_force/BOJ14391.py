n, m = map(int, input().split())
paper = [list(map(int, input())) for _ in range(n)]

answer = -1
for case in range(1 << (n*m)):
    sum = 0

    for i in range(n):
        num = 0
        for j in range(m):
            idx = i * m + j
            if (case & (1 << idx)) == 0:
                num = num * 10 + paper[i][j]
            else:
                sum += num
                num = 0
        sum += num

    for i in range(m):
        num = 0
        for j in range(n):
            idx = j * m + i
            if (case & (1 << idx)) != 0:
                num = num * 10 + paper[j][i]
            else:
                sum += num
                num = 0
        sum += num

    answer = max(answer, sum)

print(answer)
