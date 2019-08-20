t = int(input())


def find_year(m, n, x, y):
    x2 = 1
    y2 = 1
    year = 1
    while year <= m*n:
        if x2 != x:
            x2 = year % m
            y2 = year % n
            if x2 == 0:
                x2 = m
            if y2 == 0:
                y2 = n

            if x2 == x and y2 == y:
                return year

            if x2 == x:
                year += m
            else:
                year += 1
            continue

        y2 = year % n
        if y2 == 0:
            y2 = n

        if y2 == y:
            return year

        year += m
    return -1


for _ in range(t):
    m, n, x, y = map(int, input().split())
    print(find_year(m, n, x, y))
