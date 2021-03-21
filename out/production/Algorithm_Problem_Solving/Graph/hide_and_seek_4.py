# https://www.acmicpc.net/problem/13913

from collections import deque

n, m = map(int, input().split())
MAX = max(n, m) * 2 + 1
time_move = [-1] * MAX
prev_position = [-1] * MAX


queue = deque()
queue.append(n)
time_move[n] = 0
prev_position[n] = n

while queue:
    position = queue.popleft()

    if position - 1 >= 0 and time_move[position-1] == -1:
        time_move[position-1] = time_move[position] + 1
        prev_position[position-1] = position
        queue.append(position-1)

    if position + 1 < MAX and time_move[position+1] == -1:
        time_move[position+1] = time_move[position] + 1
        prev_position[position+1] = position
        queue.append(position+1)

    if position * 2 < MAX and time_move[position*2] == -1:
        time_move[position*2] = time_move[position] + 1
        prev_position[position*2] = position
        queue.append(position*2)

print(time_move[m])
path = []
prev = m
path.append(m)

while prev != n:
    prev = prev_position[prev]
    path.append(prev)

path.reverse()

for i in range(len(path)):
    print(path[i], end=' ')
