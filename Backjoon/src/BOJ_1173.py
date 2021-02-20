# 운동 (https://www.acmicpc.net/problem/1173)


# N = 운동
# m = 최소 맥박
# M = 최대 맥박
# T = 운동할 때 증가하는 맥박
# R = 휴식할 때 감소하는 맥박
# 1 <= N, T, R <= 200
# 50 <= m ≤ M <= 200
N, m, M, T, R = map(int, input().split())
X = m

if T > M - m:
    print(-1)
    exit()

cnt = 0
while N > 0:

    if X + T <= M:
        X += T
        N -= 1
    else:
        X -= R

        if m > X:
            X = m

    cnt += 1

print(cnt)
