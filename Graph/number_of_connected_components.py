import sys
from collections import deque
q = deque()

# input
vertex_num, edge_num = map(int, sys.stdin.readline().split(' '))


def create_adjacency_list(vertex_num, edge_num):

    graph = {}

    # input edges & create a graph
    for i in range(edge_num):
        u, v = map(int, sys.stdin.readline().split(' '))
        if u in graph:
            graph[u].append(v)
        else:
            graph[u] = [v]

        if v in graph:
            graph[v].append(u)
        else:
            graph[v] = [u]  

    return graph


graph = create_adjacency_list(vertex_num, edge_num)


check = [False] * (vertex_num+1)


def bfs(x, vertex_num):

    check[x] = True

    # Add start vertex to deque
    q.append(x)

    while q:
        x = q.popleft()

        list = graph[x]
        
        for i in range(len(list)):
            adjacency_vertex = list[i]
            if check[adjacency_vertex] == False:
                check[adjacency_vertex] = True
                q.append(adjacency_vertex)


components = 0
for i in range(1, vertex_num+1):
    if i in graph:
        if check[i] == False:
            components += 1
            bfs(i, vertex_num)
    else:
        components += 1

print(components)