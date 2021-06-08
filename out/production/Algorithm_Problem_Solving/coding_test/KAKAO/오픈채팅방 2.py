from collections import deque


def solution(record):
    answer = []
    info = []
    queue = deque()
    user = {}
    for case in record:
        info = case.split()
        queue.append((info[0], info[1]))
        if len(info) == 3:
            user[info[1]] = info[2]

    while(queue):
        cmd, id = queue.popleft()
        nickname = user[id]

        if cmd == "Enter":
            answer.append(nickname + "님이 들어왔습니다.")
        elif cmd == "Leave":
            answer.append(nickname + "님이 나갔습니다.")

    return answer
