# 4 연산 (https://www.acmicpc.net/problem/14395)

import sys
from collections import deque

s, t = map(int, sys.stdin.readline().split())
dp = set()
if s == t:
    print(0)
    exit()

q = deque()

q.append((s, ""))
while q:
    v, code = q.popleft()

    if v == t:
        print(code)
        exit()

    if v * v <= t:
        if v * v not in dp:
            temp = v * v
            dp.add(temp)
            q.append((v * v, code + "*"))

    if v + v <= t:
        if v + v not in dp:
            temp = v + v
            dp.add(temp)
            q.append((v + v, code + "+"))

    if v != 0:
        if v / v not in dp:
            temp = v / v
            dp.add(temp)
            q.append((v / v, code + "/"))

print(-1)
