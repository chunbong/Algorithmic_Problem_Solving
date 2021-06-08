# https://www.acmicpc.net/problem/10825

grades = []

n = int(input())

for i in range(n):
    name, kor, enh, math = map(str, input().strip().split(' '))
    grades.append((name, int(kor), int(enh), int(math)))

grades.sort(key=lambda x: (-x[1], x[2], -x[3], x[0]))

for el in grades:
    print(el[0])
