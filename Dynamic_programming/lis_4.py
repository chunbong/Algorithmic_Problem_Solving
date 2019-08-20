n = int(input())
seq = list(map(int, input().split()))

answer = [0] * n
prev_visit = [-1] * n

for i in range(n):
    answer[i] = 1
    tmp = 0
    for j in range(i):
        if seq[j] < seq[i] and answer[j] + 1 > answer[i]:
            answer[i] = answer[j] + 1
            prev_visit[i] = j

print(max(answer))

# subsequence 찾기
subseq_length = max(answer)
visit_index = answer.index(subseq_length)
answer_seq = []

for _ in range(subseq_length):
    answer_seq.append(seq[visit_index])
    visit_index = prev_visit[visit_index]


# subsequence 출력
answer_seq.reverse()
for i in range(subseq_length):
    print(answer_seq[i], end=' ')
