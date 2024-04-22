import heapq
import sys
input = sys.stdin.readline

INF = int(1e9)
v, e = map(int, input().split())
start = int(input())
graph = [[] * (v+1) for _ in range(v+1)]

for _ in range(e):
    a, b, c = map(int, input().split())
    graph[a].append((b, c))

distance = [INF] * (v+1)

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

dijkstra(start)
for i in distance[1:]:
    if i == INF:
        print('INF')
    else:
        print(i)