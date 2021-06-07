n = int(input())
seq = list(map(int, input().split()))

answer = [0] * n
answer[0] = seq[0]
for i in range(1, n):
    including = answer[i-1] + seq[i]
    notIncluded = seq[i]
    answer[i] = max(including, notIncluded)

print(max(answer))
