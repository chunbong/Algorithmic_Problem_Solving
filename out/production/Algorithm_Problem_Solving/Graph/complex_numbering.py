# https://www.acmicpc.net/problem/2667

n = int(input())

# 지도 입력
map = [list(map(int, input())) for _ in range(n)]
check = [[0]*n for _ in range(n)]

# 위, 아래, 왼쪽, 오른쪽 좌표 계산을 위해
distance_x = [-1, 1, 0, 0]
distance_y = [0, 0, -1, 1]


def dfs(x, y, complex_number):
    check[x][y] = complex_number
    for i in range(4):
        next_x = x + distance_x[i]
        next_y = y + distance_y[i]
        if 0 <= next_x < n and 0 <= next_y < n:
            if map[next_x][next_y] == 1 and check[next_x][next_y] == 0:
                dfs(next_x, next_y, complex_number)


complex_number = 0
for i in range(n):
    for j in range(n):
        if map[i][j] == 1 and check[i][j] == 0:
            complex_number += 1
            dfs(i, j, complex_number)

print(complex_number)


house_count = [0] * (complex_number+1)
for i in range(n):
    for j in range(n):
        if check[i][j] != 0:
            house_count[check[i][j]] += 1

house_count.sort()
for i in range(1, len(house_count)):
    print(house_count[i])
