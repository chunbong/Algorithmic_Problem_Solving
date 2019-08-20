def solution(answers):
    answer = []

    p1 = [1, 2, 3, 4, 5]
    p2 = [2, 1, 2, 3, 2, 4, 2, 5]
    p3 = [3, 3, 1, 1, 2, 2, 4, 4, 5, 5]

    j, k, z = 0, 0, 0
    p1_score, p2_score, p3_score = 0, 0, 0
    for i in range(len(answers)):
        if j >= 5:
            j = 0
        if k >= 8:
            k = 0
        if z >= 10:
            z = 0

        if p1[j] == answers[i]:
            p1_score += 1
        if p2[k] == answers[i]:
            p2_score += 1
        if p3[z] == answers[i]:
            p3_score += 1

        j += 1
        k += 1
        z += 1

    max_score = max(p1_score, p2_score, p3_score)
    if p1_score == max_score:
        answer.append(1)
    if p2_score == max_score:
        answer.append(2)
    if p3_score == max_score:
        answer.append(3)

    answer.sort()

    return answer


# answers = [1,2,3,4,5]
# answers = [1,3,2,4,2]
answers = [5, 5, 5, 5]

print(solution(answers))
