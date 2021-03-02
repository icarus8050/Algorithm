# 최소비용 구하기 2 (https://www.acmicpc.net/problem/11779)

import sys
from queue import PriorityQueue

MAX = sys.maxsize

n = int(sys.stdin.readline())
m = int(sys.stdin.readline())
dist = [MAX for _ in range(n + 1)]
path = [-1 for _ in range(n + 1)]
city = [[] for _ in range(n + 1)]

for i in range(m):
    a, b, c = map(int, sys.stdin.readline().split())
    city[a].append((b, c))

start, end = map(int, sys.stdin.readline().split())

dist[start] = 0
q = PriorityQueue()
q.put((0, start))
while q.qsize():
    cost, pos = q.get()
    for next, nextCost in city[pos]:
        nextCost += dist[pos]
        if dist[next] > nextCost:
            dist[next] = nextCost
            path[next] = pos
            q.put((nextCost, next))

temp = end
route = [end]
while path[temp] != -1:
    route.append(path[temp])
    temp = path[temp]
route.reverse()

print(dist[end])
print(len(route))
print(*route)
