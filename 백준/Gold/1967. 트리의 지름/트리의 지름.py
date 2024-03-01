import heapq
import sys
input = sys.stdin.readline
INF = int(1e9)

n = int(input())
graph = [[] for _ in range(n+1)]

for _ in range(n-1):
    a, b, c = map(int, input().split())
    graph[a].append((b, c))
    graph[b].append((a, c))

def dijkstra(start):
    distance = [INF] * (n+1)
    q = []
    heapq.heappush(q, (0, start))
    distance[start] = 0
    while q:
        dist, now = heapq.heappop(q)

        if distance[now] < dist:
            continue
        for i in graph[now]:
            cost = dist + i[1]
            if distance[i[0]] > cost:
                distance[i[0]] = cost
                heapq.heappush(q, (cost, i[0]))
    return distance

dist = dijkstra(1)
nextIdx, maxVal = 0, -1
for i in range(1, n+1):
    if dist[i] > maxVal:
        nextIdx = i
        maxVal = dist[i]
newDist = dijkstra(nextIdx)
print(max(newDist[1:]))