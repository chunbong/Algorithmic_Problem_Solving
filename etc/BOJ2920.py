nums = list(map(int, input().split()))

answer = None
for i in range(7):
    if nums[i] < nums[i+1]:
        if answer == None:
            answer = "ascending"
        elif answer == "descending":
            answer = "mixed"
            break
    else:
        if answer == None:
            answer = "descending"
        elif answer == "ascending":
            answer = "mixed"
            break

print(answer)