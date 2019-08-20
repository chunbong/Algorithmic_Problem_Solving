# https://www.acmicpc.net/problem/2529
# http://bit.ly/chunbong_Algorithm_solution

import itertools

k = int(input())
inequality_sign = input().split()

numbers = [0, 1, 2, 3, 4, 5, 6, 7, 8, 9]

max_set = numbers[-(k+1):]
min_set = numbers[k::-1]

max_result = ''.join(map(str, max_set))
min_result = ''.join(map(str, min_set))

def check(permutation):
   prev = 0
   next = 1
   for sign in inequality_sign:
      if sign == '>' and permutation[prev] < permutation[next]:
         return False
      elif sign == '<' and permutation[prev] > permutation[next]:
         return False
      
      prev += 1
      next += 1
   
   return True


for permutation in itertools.permutations(max_set):
   if check(permutation):
      tmp = ''.join(map(str, permutation))
      if tmp > max_result:
         max_result = tmp

for permutation in itertools.permutations(min_set):
   if check(permutation):
      tmp = ''.join(map(str, permutation))
      if tmp < min_result:
         min_result = tmp


print(max_result)
print(min_result)
