# https://www.acmicpc.net/problem/2609

def gcd(a, b):
    while ( b != 0 ):
        r = a % b
        a = b
        b = r
    return a

a, b = map(int, input().strip().split(' '))

g = gcd(a, b)
l = (a * b) / g

print(g)
print(int(l))