import heapq
import sys
input = sys.stdin.readline
INF = int(1e9)

n = int(input())
m = int(input())

graph = [[] * (n+1) for _ in range(n+1)]
for _ in range(m):
    a, b = map(int, input().split())
    graph[a].append((b, 1))
    graph[b].append((a, 1))
    
distance = [INF] * (n+1)
def dijkstra(start):
    q = []
    heapq.heappush(q, (0, start))
    distance[start] = 0
    
    while q:
        dist, now = heapq.heappop(q)
        
        if distance[now] < dist:
            continue
        
        for i in graph[now]:
            cost = i[1] + dist
            if distance[i[0]] > cost:
                distance[i[0]] = cost
                heapq.heappush(q, (cost, i[0]))

dijkstra(1)

count = 0
for i in distance:
    if 0 < i <= 2:
        count += 1
print(count)