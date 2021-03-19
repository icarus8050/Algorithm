# 카드 1 (https://www.acmicpc.net/problem/2161)

import sys

n = int(sys.stdin.readline())

arr = [x for x in range(1, n + 1)]
removed = []

while len(arr) != 1:
    removed.append(arr.pop(0))
    arr.append(arr.pop(0))

removed.append(arr.pop(0))
print(*removed)
