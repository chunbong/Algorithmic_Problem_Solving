from collections import deque
q = deque()


n, m, v = map(int, input().strip().split(' '))


graph = {}

for i in range(m):
   v1, v2 = map(int, input().strip().split(' '))

   if v1 in graph:
      graph[v1].append(v2)
   else:
      graph[v1] = [v2]
   
   if v2 in graph:
      graph[v2].append(v1)
   else:
      graph[v2] = [v1]


check = [False] * (n+1)

def dfs(v, m):

   check[v] = True
   print(v, end=" ")

   list = graph[v]
   list.sort()
   for i in range(len(list)):
      adjacency_vertex = list[i]
      if check[adjacency_vertex] == False:
         dfs(adjacency_vertex, m)


def bfs(v, m):

   check = [False] * (n+1)
   check[v] = True
   q.append(v)

   while q:
      v = q.popleft()
      print(v, end=" ")

      list = graph[v]
      list.sort()
      for i in range(len(list)):
         adjacency_vertex = list[i]
         if check[adjacency_vertex] == False:
            check[adjacency_vertex] = True
            q.append(adjacency_vertex)



dfs(v, m)
print()
bfs(v, m)
print()