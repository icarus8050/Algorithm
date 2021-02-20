# 온라인 판매 (https://www.acmicpc.net/problem/1246)

import sys
input = sys.stdin.readline

n, m = map(int, input().split())

customer = []
for i in range(m):
    p = int(input())
    customer.append(p)

price = 0
total = 0

length = len(customer)
customer.sort()

for idx, p in enumerate(customer):
    sales = min(m - idx, n)
    temp = p * sales

    if temp > total:
        price = p
        total = temp

print(price, total)