import math

n = int(input())
matrix = [ list(map(int, input().split())) for _ in range(n) ]
route = list(range(n))


def next_route(route):
    i = len(route) - 1
    while i > 0 and route[i-1] >= route[i]:
        i -= 1
    
    if i <= 0:
        return False
    
    j = len(route) - 1
    while route[i-1] >= route[j]:
        j -= 1
    route[i-1], route[j] = route[j], route[i-1]

    j = len(route) - 1
    while i < j:
        route[i], route[j] = route[j], route[i]
        i += 1
        j -= 1
    
    return True


answer = math.inf

while True:
    cost = 0
    complete = True

    for i in range(n-1):
        vertex1 = route[i]
        vertex2 = route[i+1]
        if matrix[vertex1][vertex2] == 0:
            complete = False
            break
        else:
            cost += matrix[vertex1][vertex2]
    
    end = route[n-1]
    start = route[0]
    if complete and matrix[end][start] != 0:
        cost += matrix[end][start]
        answer = min(answer, cost)
    
    if not next_route(route):
        break

print(answer)