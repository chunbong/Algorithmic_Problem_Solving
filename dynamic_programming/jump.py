# https://www.acmicpc.net/problem/1890

n = int(input())
board = [[0]*(n+1)] + [[0]+list(map(int, input().split())) for _ in range(n)]
answer = [[0]*(n+1) for _ in range(n+1)]

answer[1][1] = 1
for i in range(1, n+1):
    for j in range(1, n+1):
        if i == n and j == n:
            continue
        if answer[i][j] != 0:
            if j + board[i][j] <= n:
                answer[i][j+board[i][j]] += answer[i][j]
            if i + board[i][j] <= n:
                answer[i+board[i][j]][j] += answer[i][j]

print(answer[n][n])
