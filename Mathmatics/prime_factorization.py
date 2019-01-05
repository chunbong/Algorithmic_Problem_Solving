# https://www.acmicpc.net/problem/11653

num = int(input())

i = 2
while i * i <= num:
    while num % i == 0:
        print(i)
        num //= i
    i += 1
    
if num > 1:
    print(num)