n, m = map(int, input().split())
cardNum = list(map(int, input().split()))

def sumCards(selectedCards):
    answer = 0
    for i in range(n):
        if selectedCards[i]:
            answer += cardNum[i]
    return answer

remaining = 3
selectedCards = [False] * n
def findAnswer(remaining, selectedCards, idx):
    if remaining == 0:
        return sumCards(selectedCards)
    if idx == n:
        return 0
    
    selectedCards[idx] = True
    case1 = findAnswer(remaining-1, selectedCards, idx+1)
    if case1 > m:
        case1 = 0
    selectedCards[idx] = False
    case2 = findAnswer(remaining, selectedCards, idx+1)
    if case2 > m:
        case2 = 0
        
    return max(case1, case2)


print(findAnswer(remaining, selectedCards, 0))
