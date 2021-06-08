# https://www.acmicpc.net/problem/11650

coordinates_list = []

n = int(input())

for i in range(n):
    x, y = map(int, input().strip().split(' '))
    coordinates_list.append((x, y))

coordinates_list.sort()

for coordinates in coordinates_list:
    print(coordinates[0], coordinates[1])
