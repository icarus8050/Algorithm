# 아기 상어 2 (https://www.acmicpc.net/problem/17086)

import sys
from collections import deque

n, m = map(int, sys.stdin.readline().split())

sea = [[0 for _ in range(m)] for _ in range(n)]
visited = [[False for _ in range(m)] for _ in range(n)]
q = deque()
ans = 0

for i in range(n):
    row = list(map(int, sys.stdin.readline().split()))
    for j in range(m):
        if row[j] == 1:
            q.append((i, j))
            visited[i][j] = True

while q:
    y, x = q.popleft()
    next = sea[y][x] + 1

    if x > 0 and not visited[y][x - 1]:
        sea[y][x - 1] = next
        q.append((y, x - 1))
        visited[y][x - 1] = True

    if x < m - 1 and not visited[y][x + 1]:
        sea[y][x + 1] = next
        q.append((y, x + 1))
        visited[y][x + 1] = True

    if y > 0 and not visited[y - 1][x]:
        sea[y - 1][x] = next
        q.append((y - 1, x))
        visited[y - 1][x] = True

    if y < n - 1 and not visited[y + 1][x]:
        sea[y + 1][x] = next
        q.append((y + 1, x))
        visited[y + 1][x] = True

    if x > 0 and y > 0 and not visited[y - 1][x - 1]:
        sea[y - 1][x - 1] = next
        q.append((y - 1, x - 1))
        visited[y - 1][x - 1] = True

    if x < m - 1 and y > 0 and not visited[y - 1][x + 1]:
        sea[y - 1][x + 1] = next
        q.append((y - 1, x + 1))
        visited[y - 1][x + 1] = True

    if x < m - 1 and y < n - 1 and not visited[y + 1][x + 1]:
        sea[y + 1][x + 1] = next
        q.append((y + 1, x + 1))
        visited[y + 1][x + 1] = True

    if x > 0 and y < n - 1 and not visited[y + 1][x - 1]:
        sea[y + 1][x - 1] = next
        q.append((y + 1, x - 1))
        visited[y + 1][x - 1] = True

for i in range(n):
    ans = max(ans, max(sea[i]))

print(ans)
