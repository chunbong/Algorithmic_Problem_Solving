# https://www.acmicpc.net/problem/15650

n, m = map(int, input().split())
check_duplicate = [False] * (n+1)
answer = [0] * m


def find_seq(index):
    if index == m:
        print(' '.join(map(str, answer)))
        return

    for i in range(1, n+1):
        if check_duplicate[i]:
            continue

        if answer[index-1] < i or index == 0:
            check_duplicate[i] = True
            answer[index] = i
            find_seq(index+1)

        check_duplicate[i] = False


find_seq(0)
