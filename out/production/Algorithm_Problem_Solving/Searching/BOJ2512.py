answer = 0
n = int(input())
budgetRequest = list(map(int, input().split()))
totalBudget = int(input())


sumBudgetRequest = sum(budgetRequest)

if sumBudgetRequest < totalBudget:
    answer = max(budgetRequest)
else:
    leftbound = 0
    rightbound = max(budgetRequest)

    while leftbound <= rightbound:
        mid = (leftbound + rightbound) // 2
        sumBudgetRequest = 0
        for i in range(n):
            if budgetRequest[i] > mid:
                sumBudgetRequest += mid
            else:
                sumBudgetRequest += budgetRequest[i]

        if sumBudgetRequest <= totalBudget:
            if mid > answer:
                answer = mid
            leftbound = mid + 1
        else:
            rightbound = mid - 1

print(answer)
