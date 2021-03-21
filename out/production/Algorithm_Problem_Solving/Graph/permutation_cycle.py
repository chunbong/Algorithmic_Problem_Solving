import sys
sys.setrecursionlimit(2000)

graph = {}
answers = []


def create_graph(permutation):

   for i in range(len(permutation)):
      graph[i+1] = int(permutation[i])


def dfs(vertex_num):

   if visited[vertex_num] == True:
      return
   
   visited[vertex_num] = True
   dfs(graph[vertex_num])


test_case = int(sys.stdin.readline())

for i in range(test_case):
   permutation_size = int(sys.stdin.readline())
   permutation = sys.stdin.readline().rstrip().split(' ')
   create_graph(permutation)

   visited = [False] * (len(permutation)+1)
   count = 0

   for i in range(1, len(permutation)+1):
      if visited[i] == False:
         dfs(i)
         count += 1

   answers.append(count)


for answer in answers:
   print(answer)