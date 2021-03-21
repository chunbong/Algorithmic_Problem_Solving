testCase = int(input())

for _ in range(testCase):
    n, m = map(int, input().split())
    q = list(map(int, input().split()))

    priorityQ = sorted(q, reverse=True)   # 중요도를 내림차순으로 정렬
    q = [t for t in enumerate(q)]   # (index, 중요도)로 q를 구성

    count = 0
    while True:
        if q[0][1] == priorityQ[0]:   # q[0]의 중요도가 q 내 가장 큰 중요도와 같을 때
            count += 1
            if q[0][0] == m:
                print(count)
                break
            else:
                q.pop(0)
                priorityQ.pop(0)  # 출력이 됐으면 중요도도 pop을 해서 다음 중요도가 가장 앞에 올 수 있도록
        else:
            temp = q.pop(0)  # 출력이 되지 않았으면 문서만 맨 뒤로 배치
            q.append(temp)