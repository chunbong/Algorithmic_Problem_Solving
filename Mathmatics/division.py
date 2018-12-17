#https://www.acmicpc.net/problem/10430

def solution(A, B, C):
    print((A+B)%C)
    print(((A%C) + (B%C))%C)
    print((A*B)%C)
    print(((A%C) * (B%C))%C)

A, B, C = map(int, input().strip().split(' '))
solution(A, B, C)