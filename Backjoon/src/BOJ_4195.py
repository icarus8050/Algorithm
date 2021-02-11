# 친구 네트워크 (https://www.acmicpc.net/problem/4195)

import sys

def find(x):
    if x == parents[x]:
        return x

    parents[x] = find(parents[x])
    return parents[x]

def union(x, y):
    x = find(x)
    y = find(y)

    if x != y:
        parents[y] = x
        relations[x] += relations[y]
    return relations[x]

t = int(sys.stdin.readline().strip())
for i in range(t):
    relations, parents = {}, {}

    n = int(sys.stdin.readline().strip())

    for j in range(n):
        a, b = sys.stdin.readline().split()

        if a not in relations:
            parents[a] = a
            relations[a] = 1

        if b not in relations:
            parents[b] = b
            relations[b] = 1

        print(union(a, b))
