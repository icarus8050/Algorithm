# 안전 영역 (https://www.acmicpc.net/problem/2468)

import sys
from collections import deque

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
                    x, y = queue.popleft()

                    if x > 0 and not visited[y][x - 1] and area[y][x - 1] > rain:
                        visited[y][x - 1] = True
                        queue.append((x - 1, y))

                    if x < n - 1 and not visited[y][x + 1] and area[y][x + 1] > rain:
                        visited[y][x + 1] = True
                        queue.append((x + 1, y))

                    if y > 0 and not visited[y - 1][x] and area[y - 1][x] > rain:
                        visited[y - 1][x] = True
                        queue.append((x, y - 1))

                    if y < n - 1 and not visited[y + 1][x] and area[y + 1][x] > rain:
                        visited[y + 1][x] = True
                        queue.append((x, y + 1))

                areaCount += 1

    maxArea = max(maxArea, areaCount)

print(maxArea)
