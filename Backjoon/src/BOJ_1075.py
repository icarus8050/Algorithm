# 나누기 (https://www.acmicpc.net/problem/1075)

n = input()
f = int(input())


frontStr = n[0:-2]
frontNum = int(frontStr)

i = 0
while i < 100:
    if (frontNum * 100 + i) % f == 0:
        break

    i += 1

if i < 10:
    s = str(i)
    print('0' + s)
else:
    print(i)