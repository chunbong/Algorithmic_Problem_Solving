import sys
sys.setrecursionlimit(10000)

n = int(input())
a = list(map(int, input().split()))
m = int(input())
nums = list(map(int, input().split()))


def binary_search(target, start, end, data):
    if start > end:
        return 0

    mid = (start + end) // 2

    if data[mid] == target:
        return 1

    if data[mid] < target:
        start = mid + 1
    else:
        end = mid - 1

    return binary_search(target, start, end, data)


a.sort()

for i in range(m):
    print(binary_search(nums[i], 0, n-1, a))
