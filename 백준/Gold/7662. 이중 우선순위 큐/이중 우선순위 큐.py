import sys
import heapq
input = sys.stdin.readline

t = int(input())
for _ in range(t):
    n = int(input())
    visited = [True] * n
    minQ = []
    maxQ = []
    for i in range(n):
        cmd, temp = input().split()
        num = int(temp)
        if cmd == 'I':
            heapq.heappush(minQ, (num, i))
            heapq.heappush(maxQ, (-num, i))

        else:
            if num == -1:
                if minQ:
                    value, idx = heapq.heappop(minQ)
                    visited[idx] = False
            else:
                if maxQ:
                    value, idx = heapq.heappop(maxQ)
                    visited[idx] = False
        
        while minQ and visited[minQ[0][1]] == False:
            heapq.heappop(minQ)
        while maxQ and visited[maxQ[0][1]] == False:
            heapq.heappop(maxQ)
    
    if minQ and maxQ:
        maxValue, idx = heapq.heappop(maxQ)
        minValue, idx = heapq.heappop(minQ)
        print(-maxValue, minValue)
    else:
        print("EMPTY")