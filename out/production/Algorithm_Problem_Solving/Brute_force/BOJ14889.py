import sys

n = int(input())
s = [list(map(int, input().split())) for _ in range(n)]


answer = sys.maxsize
for subset in range(1, 1 << n):
    start = []
    link = []
    if bin(subset).count("1") == (n // 2):
        for i in range(n):
            if subset & (1 << i):
                start.append(i)
            else:
                link.append(i)
    else:
        continue

    start_capacity = 0
    link_capacity = 0
    for i in range(n//2):
        for j in range(n//2):
            if i == j:
                continue
            start_capacity += s[start[i]][start[j]]
            link_capacity += s[link[i]][link[j]]

    if abs(start_capacity - link_capacity) < answer:
        answer = abs(start_capacity - link_capacity)

print(answer)
