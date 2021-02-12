# 토마토 (https://www.acmicpc.net/problem/7576)

import sys

def isValidPosition(nx, ny):
    return (0 <= nx < m) and (0 <= ny < n)

def isAllRipen():
    for i in range(n):
        for j in range(m):
            if tomatos[i][j] == 0:
                return False
    return True

dx = [-1, 0, 1, 0]
dy = [0, -1, 0, 1]
m, n = map(int, sys.stdin.readline().split())
tomatos = [[0 for _ in range(m)] for _ in range(n)]
visited = [[False for _ in range(m)] for _ in range(n)]
queue1 = []
queue2 = []
days = -1

for i in range(n):
    arr = list(map(int, sys.stdin.readline().split()))

    for j in range(m):
        tomatos[i][j] = arr[j]
        if arr[j] == 1:
            queue1.append((j, i))

while True:
    if len(queue1):
        while len(queue1):
            position = queue1.pop()
            for i in range(4):
                nx = position[0] + dx[i]
                ny = position[1] + dy[i]

                if isValidPosition(nx, ny) and not visited[ny][nx] and tomatos[ny][nx] == 0:
                    visited[ny][nx] = True
                    tomatos[ny][nx] = 1
                    queue2.append((nx, ny))
    elif len(queue2):
        while len(queue2):
            position = queue2.pop()
            for i in range(4):
                nx = position[0] + dx[i]
                ny = position[1] + dy[i]

                if isValidPosition(nx, ny) and not visited[ny][nx] and tomatos[ny][nx] == 0:
                    visited[ny][nx] = True
                    tomatos[ny][nx] = 1
                    queue1.append((nx, ny))
    days += 1

    if not len(queue1) and not len(queue2):
        break

if isAllRipen():
    print(days)
else:
    print(-1)