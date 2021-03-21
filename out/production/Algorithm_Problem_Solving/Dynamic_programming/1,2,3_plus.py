t = int(input())

MAX = 11

for _ in range(t):
    answer = [0] * MAX
    answer[1] = 1
    answer[2] = 2
    answer[3] = 4
    n = int(input())
    for i in range(4, n+1):
        answer[i] = answer[i-1] + answer[i-2] + answer[i-3]

    print(answer[n])
