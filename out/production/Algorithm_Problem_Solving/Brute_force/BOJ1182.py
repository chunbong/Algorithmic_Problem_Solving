n, s = map(int, input().split())
nums = list(map(int, input().split()))

elements = (1 << n) - 1
subset = elements
answer = 0
while subset != 0:
    sum = 0
    for i in range(n):
        if subset & (1 << i):
            sum += nums[i]

    if sum == s:
        answer += 1

    subset = (subset-1) & elements

print(answer)
