# 빵집 (https://www.acmicpc.net/problem/3109)

import sys
sys.setrecursionlimit(10 ** 6)

def route(y, x):
    global constructed, ans, dy, r, c
    if x == c - 1:
        ans += 1
        return True

    constructed[y][x] = True

    for i in range(3):
        ny = y + dy[i]

        if 0 <= ny < r and not constructed[ny][x + 1]:
            if route(ny, x + 1):
                return True

dy = [-1, 0, 1]
r, c = map(int, sys.stdin.readline().split())
ans = 0

constructed = [[False for _ in range(c)] for _ in range(r)]

for i in range(r):
    s = sys.stdin.readline().rstrip()
    for j in range(c):
        if s[j] == 'x':
            constructed[i][j] = True

for i in range(r):
    route(i, 0)

print(ans)
