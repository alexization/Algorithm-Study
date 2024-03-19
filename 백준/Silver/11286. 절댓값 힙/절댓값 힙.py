import heapq
import sys
input = sys.stdin.readline

n = int(input())
q = []
for _ in range(n):
    v = int(input())
    if v != 0:
        heapq.heappush(q, (abs(v), v))
        continue
    
    if len(q) == 0:
        print(0)
    else:
        value = heapq.heappop(q)
        print(value[1])