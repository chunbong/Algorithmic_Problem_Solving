# https://www.acmicpc.net/problem/11576

a, b = map(int, input().strip().split(' '))
m = int(input())
nums = (input().split(' '))

a_base_num = 0
exponent = m - 1
converted_num = []

# A진법 수를 10진법 수로 변환
for i in range(m):
    a_base_num += int(nums[i]) * ( a ** exponent )
    exponent -= 1

# 10진법 수를 B진법 수로 변환
while a_base_num != 0:
    converted_num.append(a_base_num % b)
    a_base_num //= b

converted_num.reverse()
print(' '.join(str(x) for x in converted_num), end='')