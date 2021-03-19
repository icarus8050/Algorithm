# 요세푸스 문제 (https://www.acmicpc.net/problem/1158)

import sys

n, k = map(int, sys.stdin.readline().split())

arr = [x for x in range(1, n + 1)]
removed = []
i = 0

while len(arr):
    i = i + k - 1
    i %= len(arr)
    removed.append(arr.pop(i))

print('<', end='')
print(*removed, sep=', ', end='')
print('>')
