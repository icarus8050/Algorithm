# 이상한 곱셈 (https://www.acmicpc.net/problem/1225)

a, b = input().split()

result = 0
store = {}

for i in a:
    aNum = int(i)
    if aNum in store:
        result += store[aNum]
    else:
        val = 0
        for j in b:
            bNum = int(j)
            val += (aNum * bNum)
        result += val
        store[aNum] = val

print(result)
