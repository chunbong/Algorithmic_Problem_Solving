from itertools import combinations

n, m = map(int, input().split())
cardNum = list(map(int, input().split()))

answer = 0
for combination in combinations(cardNum, 3):
    threeCardsSum = sum(combination)
    if threeCardsSum <= m and threeCardsSum > answer:
        answer = threeCardsSum

print(answer)