n, s, m = map(int, input().split())
v = [0] + list(map(int, input().split()))

answer = [[0]*(m+1) for _ in range(n+1)]
answer[0][s] = 1

for i in range(1, n+1):
    for j in range(m+1):
        if answer[i-1][j] != 0:
            if j - v[i] >= 0:
                answer[i][j-v[i]] = 1
            if j + v[i] <= m:
                answer[i][j+v[i]] = 1

check = 1
for i in range(m, -1, -1):
    if answer[n][i] != 0:
        print(i)
        check = -1
        break
if check == 1:
    print(-1)
