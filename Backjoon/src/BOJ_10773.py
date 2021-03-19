# 제로 (https://www.acmicpc.net/problem/10773)

import sys

k = int(sys.stdin.readline().strip())

arr = []
for i in range(k):
    a = int(sys.stdin.readline().strip())

    if a == 0:
        arr.pop()
    else:
        arr.append(a)

print(sum(arr))