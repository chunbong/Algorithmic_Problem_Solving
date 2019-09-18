n, m = map(int, input().split())
h = list(map(int, input().split()))

maxH = max(h)
leftbound = 0
rightbound = maxH
answer = 0
while leftbound <= rightbound:
    mid = (rightbound + leftbound) // 2
    takenLength = 0
    for i in range(n):
        if h[i] > mid:
            takenLength += (h[i] - mid)
    if takenLength >= m:
        leftbound = mid + 1
        answer = mid
    else:
        rightbound = mid - 1

print(answer)
