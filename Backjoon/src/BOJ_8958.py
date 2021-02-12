# OX퀴즈 (https://www.acmicpc.net/problem/8958)

import sys

t = int(sys.stdin.readline().strip())
for i in range(t):
    quiz = sys.stdin.readline().strip()
    cnt = 0
    ans = 0
    for q in quiz:
        if q == 'O':
            cnt += 1
            ans += cnt
        else:
            cnt = 0
    print(ans)
