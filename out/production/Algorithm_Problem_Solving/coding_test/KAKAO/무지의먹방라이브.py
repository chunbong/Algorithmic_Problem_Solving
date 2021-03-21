from queue import PriorityQueue


def solution(food_times, k):
    answer = 0

    if sum(food_times) <= k:
        return -1

        # (food_times, index)를 사용해 우선순위 큐를 생성
    q = PriorityQueue()
    for i in range(len(food_times)):
        q.put((food_times[i], i+1))

    length = len(food_times)
    remaining_k = k
    prev = 0
    while (q.queue[0][0] - prev) * length <= remaining_k:
        remaining_k -= ((q.queue[0][0] - prev) * length)
        length -= 1
        prev = q.get()[0]

        # 큐에 남아있는 원소를 원래 순서대로 다시 정렬
        temp = sorted(q.queue, key=lambda x: x[1])
    target = remaining_k % length
    answer = temp[target][1]

    return answer
