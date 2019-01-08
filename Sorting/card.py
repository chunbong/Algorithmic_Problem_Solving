# 

nums = []

n = int(input())

for i in range(n):
    num = int(input())
    nums.append(num)

nums.sort()

ans = nums[0]
ans_cnt = 1
cnt = 1
for i in range(1, n):
    if nums[i] == nums[i-1]:
        cnt += 1
    else:
        cnt = 1
    
    if ans_cnt < cnt:
        ans_cnt = cnt
        ans = nums[i]

print(ans)