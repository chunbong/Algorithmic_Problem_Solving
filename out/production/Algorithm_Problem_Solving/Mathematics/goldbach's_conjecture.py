# https://www.acmicpc.net/problem/6588

test_case = []

# input
num = int(input())
while num != 0:
    test_case.append(num)
    num = int(input())
test_case.append(num)

# 에라토스테네스의 체로 소수 구하기
prime_num = []
check = [False] * 1000001
check[0] = True
check[1] = True
for i in range(2, 1000001):
    if check[i] == False:
        prime_num.append(i)
        for j in range(i * i, 1000001, i):
            check[j] = True

for case in test_case[:-1]:
    flag = False
    for num in prime_num:
        tmp = case - num
        if check[tmp] == False:
            print(case, '=', num, '+', tmp)
            flag = True
            break
    if flag == False:
        print("Goldbach's conjecture is wrong.")