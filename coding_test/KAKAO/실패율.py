from operator import itemgetter


def solution(N, stages):
    answer = []

    stages.sort()
    l = len(stages)
    stages.append(501)
    now_stage = stages[0]
    not_clear_user = 0
    failure_rate = {}
    check = [False] * N
    i = 0
    while True:
        if stages[i] == now_stage:
            not_clear_user += 1
        else:
            reched_user = l - i + not_clear_user
            if now_stage != N+1:
                failure_rate[now_stage] = float(
                    not_clear_user) / float(reched_user)
                check[now_stage-1] = True
            now_stage = stages[i]
            if now_stage == N+1:
                break
            not_clear_user = 1

        if stages[i] == 501:
            break

        i += 1

    temp = sorted(failure_rate.items(), key=itemgetter(0))
    temp = sorted(failure_rate.items(), key=itemgetter(1), reverse=True)

    for i in range(len(temp)):
        answer.append(temp[i][0])

    for i in range(N):
        if check[i] == False:
            answer.append(i+1)

    return answer
