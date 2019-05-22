# https://www.acmicpc.net/problem/1676

n = int(input())

count_5 = n // 5
count_25 = n // 25
count_125 = n // 125
print(count_5 + count_25 + count_125)