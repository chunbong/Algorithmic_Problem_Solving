# https://www.acmicpc.net/problem/15651

n, m = map(int, input().split())
answer = [0] * m


def find_seq(index):
    if index == m:
        print(' '.join(map(str, answer)))
        return

    if index > m:
        return

    for i in range(1, n+1):
        answer[index] = i
        find_seq(index+1)


find_seq(0)
