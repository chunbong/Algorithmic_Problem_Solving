def solution(N, stages):

    usersPerStage = [0] * (N+1)
    for stage in stages:
        if stage == N+1:
            continue
        usersPerStage[stage] += 1

    failureRate = {}
    rechedUsers = len(stages)
    for stage in range(1, N+1):
        if rechedUsers != 0:
            failureRate[stage] = usersPerStage[stage] / rechedUsers
            rechedUsers -= usersPerStage[stage]
        else:
            failureRate[stage] = 0

    return sorted(failureRate, key=lambda x: failureRate[x], reverse=True)
