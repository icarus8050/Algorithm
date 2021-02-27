# 벽 부수고 이동하기 (https://www.acmicpc.net/problem/2206)

import sys
from collections import deque

dx = [-1, 0, 1, 0]
dy = [0, -1, 0, 1]

n, m = map(int, sys.stdin.readline().split())
board = [[0 for _ in range(m + 1)] for _ in range(n + 1)]
boardDist = [[[0 for _ in range(m + 1)] for _ in range(n + 1)] for _ in range(2)]

q = deque()

for i in range(1, n + 1):
    temp = sys.stdin.readline().strip()
    for j in range(1, m + 1):
        board[i][j] = int(temp[j - 1])

q.append((1, 1, 0))

while q:
    y, x, crashed = q.popleft()

    if y == n and x == m:
        print(boardDist[crashed][y][x] + 1)
        exit()

    for i in range(4):
        nx = x + dx[i]
        ny = y + dy[i]

        if (0 < nx <= m) and (0 < ny <= n):
            if board[ny][nx] == 1 and crashed == 0:
                boardDist[crashed + 1][ny][nx] = boardDist[crashed][y][x] + 1
                q.append((ny, nx, crashed + 1))
            elif board[ny][nx] == 0 and boardDist[crashed][ny][nx] == 0:
                boardDist[crashed][ny][nx] = boardDist[crashed][y][x] + 1
                q.append((ny, nx, crashed))

print(-1)
