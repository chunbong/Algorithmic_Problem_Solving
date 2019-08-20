# https://www.acmicpc.net/problem/15652

n, m = map(int, input().split())
answer = [0] * m


def find_seq(index):
    if index == m:
        print(' '.join(map(str, answer)))
        return

    for i in range(1, n+1):
        if answer[index-1] <= i or index == 0:
            answer[index] = i
            find_seq(index+1)


find_seq(0)
