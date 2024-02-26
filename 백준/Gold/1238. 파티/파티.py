import heapq
import sys
input = sys.stdin.readline
INF = int(1e9)

n, m, x = map(int, input().split())

graph = [[] for _ in range(n+1)]

for _ in range(m):
    a, b, c = map(int, input().split())
    graph[a].append((b, c))

def dijkstra(start):
    q = []
    heapq.heappush(q, (0, start))
    visited[start] = 0
    while q:
        dist, now = heapq.heappop(q)

        if visited[now] < dist:
            continue
        for i in graph[now]:
            cost = dist + i[1]

            if cost < visited[i[0]]:
                visited[i[0]] = cost
                heapq.heappush(q, (cost, i[0]))

array = [0] * (n+1)
for i in range(1, n+1):
    visited = [INF] * (n+1)
    dijkstra(i)
    if i == x:
        for j in range(1, n+1):
            array[j] += visited[j]
        continue
    array[i] += visited[x]

print(max(array))