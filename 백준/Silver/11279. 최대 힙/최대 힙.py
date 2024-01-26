import heapq
import sys

input = sys.stdin.readline

n = int(input())
data = []

for i in range(n):
    x = int(input())

    if x == 0:
        if len(data) == 0:
            print(0)
        else:
            print(-heapq.heappop(data))

    else:
        heapq.heappush(data, -x)