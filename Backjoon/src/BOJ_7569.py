# 토마토 (https://www.acmicpc.net/problem/7569)

import sys
from collections import deque


def isAllRipen():
    for i in range(h):
        for j in range(n):
            if 0 in box[i][j]:
                return False
    return True


m, n, h = map(int, sys.stdin.readline().split())
ans = 0
queue = deque()
box = [[[0] * m for _ in range(n)] for _ in range(h)]

for i in range(h):
    for j in range(n):
        tomato = list(map(int, sys.stdin.readline().split()))
        for k in range(m):
            box[i][j][k] = tomato[k]
            if tomato[k] == 1:
                queue.append((i, j, k))

while queue:
    size = len(queue)
    ans += 1
    for _ in range(size):
        z, y, x = queue.popleft()

        if x > 0 and box[z][y][x - 1] == 0:
            box[z][y][x - 1] = 1
            queue.append((z, y, x - 1))

        if x < m - 1 and box[z][y][x + 1] == 0:
            box[z][y][x + 1] = 1
            queue.append((z, y, x + 1))

        if y > 0 and box[z][y - 1][x] == 0:
            box[z][y - 1][x] = 1
            queue.append((z, y - 1, x))

        if y < n - 1 and box[z][y + 1][x] == 0:
            box[z][y + 1][x] = 1
            queue.append((z, y + 1, x))

        if z > 0 and box[z - 1][y][x] == 0:
            box[z - 1][y][x] = 1
            queue.append((z - 1, y, x))

        if z < h - 1 and box[z + 1][y][x] == 0:
            box[z + 1][y][x] = 1
            queue.append((z + 1, y, x))

if isAllRipen():
    print(ans - 1)
else:
    print(-1)
