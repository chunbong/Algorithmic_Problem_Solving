# https://www.acmicpc.net/problem/1476

e, s, m = map(int, input().split())

cal_e, cal_s, cal_m = 1, 1, 1
year = 1
while True:
    if cal_e == e and cal_s == s and cal_m == m:
        break
    if cal_e == 15:
        cal_e = 0
    if cal_s == 28:
        cal_s = 0
    if cal_m == 19:
        cal_m = 0
    cal_e += 1
    cal_s += 1
    cal_m += 1
    year += 1

print(year)