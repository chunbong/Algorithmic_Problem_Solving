import math


def next_permutation(numbered_operator):
    i = len(numbered_operator) - 1
    while i > 0 and numbered_operator[i-1] >= numbered_operator[i]:
        i -= 1

    if i <= 0:
        return False

    j = len(numbered_operator) - 1
    while numbered_operator[i-1] >= numbered_operator[j]:
        j -= 1
    numbered_operator[i -
                      1], numbered_operator[j] = numbered_operator[j], numbered_operator[i-1]

    j = len(numbered_operator) - 1
    while i < j:
        numbered_operator[i], numbered_operator[j] = numbered_operator[j], numbered_operator[i]
        i += 1
        j -= 1

    return True


n = int(input())
a = list(map(int, input().split()))
operators = list(map(int, input().split()))

numbered_operator = []
for i in range(4):
    numbered_operator += ([i] * operators[i])

min_answer = math.inf
max_answer = -2000
while True:
    result = a[0]
    for i in range(len(a)-1):
        if numbered_operator[i] == 0:
            result += a[i+1]
        elif numbered_operator[i] == 1:
            result -= a[i+1]
        elif numbered_operator[i] == 2:
            result *= a[i+1]
        else:
            if result < 0:
                result = -(-result // a[i+1])
            else:
                result //= a[i+1]

    min_answer = min(min_answer, result)
    max_answer = max(max_answer, result)

    if not next_permutation(numbered_operator):
        break

print(max_answer)
print(min_answer)
