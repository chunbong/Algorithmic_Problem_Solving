n = int(input())
a = list(map(int, input().split()))
m = int(input())
nums = list(map(int, input().split()))


set_a = set(a)
set_nums = set(nums)

intersection = set_a & set_nums

for i in range(m):
    if nums[i] in intersection:
        print(1)
    else:
        print(0)
