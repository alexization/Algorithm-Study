import heapq
import sys
input = sys.stdin.readline
INF = int(1e9)

n = int(input())

graph = [[] for _ in range(n+1)]
for _ in range(n):
    array = list(map(int, input().split()))
    v = array[0]
    length = len(array) - 2
    for i in range(2, length+1, 2):
        nv, cost = array[i-1], array[i]
        graph[v].append((nv, cost))
    
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
            if cost < distance[i[0]]:
                distance[i[0]] = cost
                heapq.heappush(q, (cost, i[0]))
    return distance

dist = dijkstra(1)
nextIdx, maxValue = 0, -1
for i in range(1, n+1):
    if maxValue < dist[i]:
        maxValue = dist[i]
        nextIdx = i

newDist = dijkstra(nextIdx)
print(max(newDist[1:]))