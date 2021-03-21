from itertools import permutations


def solution(numbers):
    answer = 0

    splitNumbers = list(numbers)

    temp = sorted(numbers, reverse=True)
    temp = ''.join(temp)
    maxNumber = int(temp)

    primeNumbers = [0] * (maxNumber + 1)
    primeNumbers[0], primeNumbers[1] = -1, -1
    for i in range(2, maxNumber+1):
        j = i * i
        while j <= maxNumber:
            primeNumbers[j] = -1
            j += i

    check = [False] * (maxNumber + 1)

    for length in range(2, len(numbers)+1):
        permutationList = permutations(splitNumbers, length)
        permutationList = set(permutationList)
        for number in permutationList:
            number = ''.join(number)
            if check[int(number)] == False and primeNumbers[int(number)] == 0:
                check[int(number)] = True
                answer += 1
