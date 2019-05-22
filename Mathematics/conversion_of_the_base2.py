# https://wwww.acmicpc.net/problem/11005

n, b = map(int, input().strip().split(' '))
answer = ""

while ( n > 0 ):
    r = n % b
    if ( r < 10 ):
        answer += str(r)
    else:
        tmp = r - 10 + ord('A')
        answer += chr(tmp)
    n //= b

print(answer[::-1])