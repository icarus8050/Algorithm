# 달팽이는 올라가고 싶다 (https://www.acmicpc.net/problem/2869)

A, B, V = input().split()
A = int(A)
B = int(B)
V = int(V)
before = V - A
diff = A - B
ans = before // diff + 1
if before % diff != 0:
    ans += 1
print(ans)
