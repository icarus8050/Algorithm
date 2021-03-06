# 단어 그룹 체커 (https://www.acmicpc.net/problem/1316)

import sys

n = int(sys.stdin.readline().rstrip())

cnt = 0
for i in range(n):
    cache = set()
    s = sys.stdin.readline().strip()

    ch = ''
    flag = True
    for c in s:
        if ch != c:
            if c in cache:
                flag = False
                break

            cache.add(ch)
            ch = c

    if flag:
        cnt += 1

print(cnt)
