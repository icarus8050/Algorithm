# 여행 가자 (https://www.acmicpc.net/problem/1976)

import sys
sys.setrecursionlimit(10 ** 6)


def find(u):
    global parent
    if parent[u] == u:
        return u
    parent[u] = find(parent[u])
    return parent[u]


def union(u, v):
    global parent
    u = find(u)
    v = find(v)
    parent[v] = u


n = int(sys.stdin.readline().rstrip())
m = int(sys.stdin.readline().rstrip())

parent = [i for i in range(n + 1)]

for i in range(n):
    city = list(map(int, sys.stdin.readline().split()))
    for j in range(i + 1, n):
        if city[j] == 1:
            union(i + 1, j + 1)

travel = list(map(int, sys.stdin.readline().split()))
current = travel[0]

for location in travel:
    if find(current) != find(location):
        print('NO')
        exit()

print('YES')
