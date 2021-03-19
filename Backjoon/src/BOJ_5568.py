# 카드 놓기 (https://www.acmicpc.net/problem/5568)

import sys


def solve(cur, val):
    global n, k, arr, cnt, cache
    if cur == k:
        if val not in cache:
            cache.add(int(val))
        return
    else:
        for i in range(n):
            if not visited[i]:
                visited[i] = True
                solve(cur + 1, val + arr[i])
                visited[i] = False


n = int(sys.stdin.readline())
k = int(sys.stdin.readline())
arr = [sys.stdin.readline().strip() for _ in range(n)]
visited = [False] * n
cache = set()

solve(0, '')
print(len(cache))
