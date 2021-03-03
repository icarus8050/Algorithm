# 모래성 (https://www.acmicpc.net/problem/10711)

import sys
from collections import deque

h, w = map(int, sys.stdin.readline().split())

d = [(0, -1), (-1, -1), (-1, 0), (-1, 1), (0, 1), (1, 1), (1, 0), (1, -1)]
castle = [list(sys.stdin.readline().rstrip()) for _ in range(h)]
wave = [[0 for _ in range(w)] for _ in range(h)]
q = deque()


for i in range(1, h - 1):
    for j in range(1, w - 1):
        for dy, dx in d:
            ny = dy + i
            nx = dx + j
            if castle[ny][nx] == '.':
                wave[i][j] += 1
        if castle[i][j] != '.' and wave[i][j] >= int(castle[i][j]):
            q.append((i, j))

cnt = 0
while q:
    tempQ = deque()

    while q:
        y, x = q.popleft()
        for dy, dx in d:
            ny = dy + y
            nx = dx + x

            if castle[ny][nx] == '.':
                continue

            wave[ny][nx] += 1
            if int(castle[ny][nx]) == wave[ny][nx]:
                tempQ.append((ny,nx))

    cnt += 1
    q = tempQ

print(cnt)
