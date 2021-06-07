# https://www.acmicpc.net/problem/11651

coordinates_list = []

n = int(input())

for i in range(n):
    x, y = map(int, input().strip().split(' '))
    coordinates_list.append((y, x))

coordinates_list.sort()

for coordinates in coordinates_list:
    print(coordinates[1], coordinates[0])
