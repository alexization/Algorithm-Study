import heapq
import sys
input = sys.stdin.readline
INF = int(1e9)

n, e = map(int, input().split())

graph = [[] for _ in range(n+1)]
for _ in range(e):
    a, b, c = map(int, input().split())
    graph[a].append((b, c))
    graph[b].append((a, c))

v1, v2 = map(int, input().split())

def dijkstra(start):
    q = []
    heapq.heappush(q, (0, start))
    distance = [INF] * (n+1)
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

result = 0
array = dijkstra(1)
result += array[v1]
array = dijkstra(v1)
result += array[v2]
array = dijkstra(v2)
result += array[n]

result2 = 0
array = dijkstra(1)
result2 += array[v2]
array = dijkstra(v2)
result2 += array[v1]
array = dijkstra(v1)
result2 += array[n]

if result >= INF and result2 >= INF:
    print(-1)
elif result <= result2:
    print(result)
else:
    print(result2)