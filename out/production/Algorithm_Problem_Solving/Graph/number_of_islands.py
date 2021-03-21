# https://www.acmicpc.net/problem/4963

import sys
sys.setrecursionlimit(1000000)

distance_x = [0, 0, 1, -1, 1, 1, -1, -1]
distance_y = [1, -1, 0, 0, 1, -1, 1, -1]


def dfs(x, y):
    check[x][y] = 1
    for i in range(8):
        next_x = x + distance_x[i]
        next_y = y + distance_y[i]
        if 0 <= next_x < h and 0 <= next_y < w:
            if islands[next_x][next_y] == 1 and check[next_x][next_y] == 0:
                dfs(next_x, next_y)


while True:
    w, h = map(int, input().split())
    if w == 0 and h == 0:
        break

    islands = [list(map(int, input().split())) for _ in range(h)]
    check = [[0]*w for _ in range(h)]

    count = 0
    for i in range(h):
        for j in range(w):
            if islands[i][j] == 1 and check[i][j] == 0:
                count += 1
                dfs(i, j)

    print(count)
