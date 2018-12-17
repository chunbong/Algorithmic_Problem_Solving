#https://www.acmicpc.net/problem/1934

def gcd(a, b):
    while ( b!= 0 ):
        r = a % b
        a = b
        b = r
    return a

case = int(input())

for i in range(case):
    a, b = map(int, input().strip().split(' '))
    g = gcd(a, b)
    print(int((a * b) / g))