import heapq
import sys
input = sys.stdin.readline
INF = int(1e9)

n = int(input())
m = int(input())

graph = [[] for _ in range(n+1)]

for _ in range(m):
    a, b, c = map(int, input().split())
    graph[a].append((b, c))

start, end = map(int, input().split())
distance = [INF] * (n+1)
parent = [-1] * (n+1)

def dijkstra(start):
    q = []
    heapq.heappush(q, (0, start))
    distance[start] = 0
    parent[start] = start

    while q:
        dist, now = heapq.heappop(q)
        
        if distance[now] < dist:
            continue
        for i in graph[now]:
            cost = i[1] + dist

            if distance[i[0]] > cost:
                distance[i[0]] = cost
                parent[i[0]] = now
                heapq.heappush(q, (cost, i[0]))

dijkstra(start)

print(distance[end])

record = []
i = end
record.append(str(i))
while i != start:
    i = parent[i]
    record.append(str(i))

print(len(record))
print(' '.join(record[::-1]))