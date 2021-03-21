n = int(input())
t = []
p = []

for _ in range(n):
    num_t, num_p = map(int, input().split())
    t.append(num_t)
    p.append(num_p)


def calculate(day, profit):
    if day > n:
        return 0

    if day == n:
        return profit

    case1 = calculate(day+t[day], profit+p[day])
    case2 = calculate(day+1, profit)

    return max(case1, case2)


print(calculate(0, 0))
