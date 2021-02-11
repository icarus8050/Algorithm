# 이중 우선순위 큐 (https://www.acmicpc.net/problem/7662)
import sys
import heapq as h

t = int(sys.stdin.readline().strip())

for t in range(t):
    k = int(sys.stdin.readline().strip())
    minHeap, maxHeap = [], []
    visited = [False] * 1_000_000

    for i in range(k):
        command, value = sys.stdin.readline().split()
        value = int(value)

        if command == 'I':
            h.heappush(minHeap, (value, i))
            h.heappush(maxHeap, (-value, i))
            visited[i] = True
        else:
            if value == 1:
                while maxHeap and not visited[maxHeap[0][1]]:
                    h.heappop(maxHeap)
                if maxHeap:
                    visited[maxHeap[0][1]] = False
                    h.heappop(maxHeap)
            else:
                while minHeap and not visited[minHeap[0][1]]:
                    h.heappop(minHeap)
                if minHeap:
                    visited[minHeap[0][1]] = False
                    h.heappop(minHeap)

    while maxHeap and not visited[maxHeap[0][1]]:
        h.heappop(maxHeap)
    while minHeap and not visited[minHeap[0][1]]:
        h.heappop(minHeap)

    if minHeap and maxHeap:
        print(maxHeap[0][0] * -1, minHeap[0][0])
    else:
        print('EMPTY')
