# https://www.acmicpc.net/problem/10813

member_list = []

n = int(input())

for i in range(n):
    age, name = map(str, input().strip().split(' '))
    member_list.append((int(age), name, i))

member_list.sort(key=lambda x: (x[0], x[2]))

for member in member_list:
    print(member[0], member[1])
