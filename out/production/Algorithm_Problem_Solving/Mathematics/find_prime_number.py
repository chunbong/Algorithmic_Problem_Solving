# https://www.acmicpc.net/problem/1978

count = int(input())
nums = input().split(' ')
answer = 0

def check_prime_number(num):
    if num < 2:
        return False
    i = 2
    while (i * i) <= num:
        if num % i == 0:
            return False
        i += 1
    return True

for i in range(count):
    if check_prime_number(int(nums[i])):
        answer += 1

print(answer)