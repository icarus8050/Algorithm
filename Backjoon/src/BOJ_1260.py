# DFS와 BFS (https://www.acmicpc.net/problem/1260)

import sys
sys.setrecursionlimit(10 ** 6)


def dfs(current):
    visited[current] = True
    ansDFS.append(current)
    for i in mapping[current]:
        if not visited[i]:
            dfs(i)


def bfs(start):
    visited[start] = True
    ansBFS.append(start)
    queue = [start]

    while queue:
        current = queue.pop(0)
        for i in mapping[current]:
            if not visited[i]:
                ansBFS.append(i)
                queue.append(i)
                visited[i] = True


n, m, v = map(int, sys.stdin.readline().split())
mapping = [[] for _ in range(n + 1)]

for i in range(m):
    a, b = map(int, sys.stdin.readline().split())
    mapping[a].append(b)
    mapping[b].append(a)

for i in range(len(mapping)):
    mapping[i].sort()

ansDFS = []
ansBFS = []

visited = [False for _ in range(n + 1)]
dfs(v)
visited = [False for _ in range(n + 1)]
bfs(v)

print(*ansDFS)
print(*ansBFS)
