# 안전 영역 (https://www.acmicpc.net/problem/2468)

import sys
from collections import deque

dx = [-1, 0, 1, 0]
dy = [0, -1, 0, 1]

n = int(sys.stdin.readline())
area = [[0 for _ in range(n)] for _ in range(n)]
heightSet = set()
maxArea = 1

for i in range(n):
    row = list(map(int, sys.stdin.readline().split()))
    for j in range(n):
        area[i][j] = row[j]
        heightSet.add(row[j])

for rain in heightSet:
    visited = [[False for _ in range(n)] for _ in range(n)]
    areaCount = 0

    for i in range(n):
        for j in range(n):
            if not visited[i][j] and area[i][j] > rain:
                queue = deque()
                visited[i][j] = True
                queue.append((j, i))

                while (queue):
                    pos = queue.popleft()
                    for d in range(4):
                        nx = pos[0] + dx[d]
                        ny = pos[1] + dy[d]

                        if (0 <= nx < n and 0 <= ny < n) and not visited[ny][nx] and area[ny][nx] > rain:
                            visited[ny][nx] = True
                            queue.append((nx, ny))

                areaCount += 1

    maxArea = max(maxArea, areaCount)

print(maxArea)
