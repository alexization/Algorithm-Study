import heapq
import sys
input = sys.stdin.readline
INF = int(1e9)

n = int(input())
a, b = map(int, input().split())
m = int(input())

graph = [[] * (n+1) for _ in range(n+1)]
for _ in range(m):
    x, y = map(int, input().split())
    graph[x].append((y, 1))
    graph[y].append((x, 1))

distance = [INF] * (n+1)

def dijkstra(start):
    q = []
    heapq.heappush(q, (0, start))
    distance[start] = 0

    while q:
        dist, now = heapq.heappop(q)
        if dist < distance[now]:
            continue

        for i in graph[now]:
            cost = i[1] + dist
            if cost < distance[i[0]]:
                distance[i[0]] = cost
                heapq.heappush(q, (cost, i[0]))

dijkstra(a)

if distance[b] == INF:
    print(-1)
else:
    print(distance[b])