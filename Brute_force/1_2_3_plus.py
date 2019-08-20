# https://www.acmicpc.net/problem/9095

t = int(input())
test_case = [ int(input()) for _ in range(t) ]


def sum(case, num, answer):
    if case < num:
        return 0
    if case == num:
        return 1
    a = sum(case, num+1, answer)
    b = sum(case, num+2, answer)
    c = sum(case, num+3, answer)
    return a + b + c

for case in test_case:
    print(sum(case, 0, 0))