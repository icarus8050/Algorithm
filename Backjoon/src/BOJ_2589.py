# 보물섬 (https://www.acmicpc.net/problem/2589)

import sys
from collections import deque


def bfs(startY, startX):
    global island, n, m, d
    length = 0
    q = deque()
    visited = [[False for _ in range(m)] for _ in range(n)]

    visited[startY][startX] = True
    q.append((startY, startX, 0))

    while q:
        y, x, dist = q.popleft()
        length = max(length, dist)

        for dy, dx in d:
            ny = y + dy
            nx = x + dx

            if (0 <= ny < n and 0 <= nx < m) and island[ny][nx] == 'L' and not visited[ny][nx]:
                visited[ny][nx] = True
                q.append((ny, nx, dist + 1))

    return length


n, m = map(int, sys.stdin.readline().split())
d = [(0, -1), (0, 1), (-1, 0), (1, 0)]

island = []
ans = 0

for i in range(n):
    s = list(sys.stdin.readline().strip())
    island.append(s)

for i in range(n):
    for j in range(m):
        if island[i][j] == 'L':
            cnt = 0
            for k in range(2, 4):
                tempY = i + d[k][0]
                if 0 <= tempY < n:
                    if island[tempY][j] == 'L':
                        cnt += 1
            if cnt == 2:
                continue

            cnt = 0
            for k in range(2):
                tempX = j + d[k][1]
                if 0 <= tempX < m:
                    if island[i][tempX] == 'L':
                        cnt += 1

            if cnt == 2:
                continue

            ans = max(ans, bfs(i, j))

print(ans)
