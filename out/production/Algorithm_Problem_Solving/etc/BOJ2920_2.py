nums = list(map(int, input().split()))

ascending = False
descending = False

for i in range(1, 8):
    if nums[i-1] > nums[i]:
        descending = True
    else:
        ascending = True

if not ascending:
    print("descending")
elif not descending:
    print("ascending")
else:
    print("mixed")
