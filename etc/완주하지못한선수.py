def solution(participant, completion):
    answer = ''

    name_dict = dict()
    for name in participant:
        if name in name_dict:
            name_dict[name] += 1
        else:
            name_dict[name] = 1

    for name in completion:
        if name in name_dict:
            name_dict[name] -= 1

    for name in participant:
        if name_dict[name] != 0:
            answer = name
    return answer


participant = ["mislav", "stanko", "mislav", "ana"]
completion = ["stanko", "ana", "mislav"]
print(solution(participant, completion))
