import heapq
import sys
input = sys.stdin.readline

n = int(input())

q = []
for _ in range(n):
    value = int(input())
    if value == 0:
        try:
            print(heapq.heappop(q))
        except:
            print(0)
    else:
        heapq.heappush(q, value)