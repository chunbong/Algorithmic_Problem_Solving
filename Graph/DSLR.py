from collections import deque


def create_command(a, b):
    prev_num = [-1] * 10001
    how_made = [0] * 10001
    cost = [-1] * 10001
    queue = deque()
    queue.append(a)
    cost[a] = 0
    prev_num[a] = a

    while queue:
        value = queue.popleft()
        command_result = (value * 2) % 10000
        add_list(command_result, value, 'D', cost, how_made, prev_num, queue)
        if value == 0:
            command_result = 9999
        else:
            command_result = value - 1
        add_list(command_result, value, 'S', cost, how_made, prev_num, queue)
        command_result = (value % 1000)*10 + value//1000
        add_list(command_result, value, 'L', cost, how_made, prev_num, queue)
        command_result = (value//10) + (value % 10)*1000
        add_list(command_result, value, 'R', cost, how_made, prev_num, queue)

    prev = prev_num[b]
    print(how_made[b], end='')
    while prev != a:
        print(how_made[prev], end='')
        prev = prev_num[prev]
    print()


def add_list(command_result, value, command, cost, how_made, prev_num, queue):
    if cost[command_result] == -1:
        cost[command_result] = cost[value] + 1
        how_made[command_result] = command
        prev_num[command_result] = value
        queue.append(command_result)


t = int(input())
for _ in range(t):
    a, b = map(int, input().split())
    create_command(a, b)
