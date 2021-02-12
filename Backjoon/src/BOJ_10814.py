# 나이순 정렬 (https://www.acmicpc.net/problem/10814)

import sys

t = int(sys.stdin.readline().strip())
members = {}

for i in range(t):
    age, name = sys.stdin.readline().split()
    age = int(age)

    if age in members:
        members[age].append(name)
    else:
        members[age] = [name]

members = sorted(members.items())

for m in members:
    for name in m[1]:
        print(m[0], name)