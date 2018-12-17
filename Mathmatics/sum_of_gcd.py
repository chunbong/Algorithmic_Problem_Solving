#https://www.acmicpc.net/problem/9613

from itertools import combinations

def gcd(item):
    a = int(item[0])
    b = int(item[1])
    while ( b!= 0 ):
        r = a % b
        a = b
        b = r
    return a

case = int(input())

for i in range(case):
    sum = 0
    items = input()
    items = items.split(' ')
    items = items[1:]

    l = list(combinations(items, 2))
    for j in l:
        sum += gcd(j)
    print(sum)