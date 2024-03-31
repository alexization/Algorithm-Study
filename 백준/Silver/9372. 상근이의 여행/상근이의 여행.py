import heapq
import sys
input = sys.stdin.readline
INF = int(1e9)

def dijkstra(start):
    q = []
    distance = [INF] * (n+1)
    heapq.heappush(q, (0, start))
    distance[start] = 0
    while q:
        dist, now = heapq.heappop(q)
        if dist > distance[now]:
            continue

        for i in graph[now]:
            cost = dist + i[1]
            if distance[i[0]] > cost:
                distance[i[0]] = cost
                heapq.heappush(q, (cost, i[0]))
    return distance
t = int(input())

for _ in range(t):
    n, m = map(int, input().split())
    graph = [[] for _ in range(n+1)]
    for _ in range(m):
        a, b = map(int, input().split())
        graph[a].append((b, 1))
        graph[b].append((a, 1))
    
    distance = dijkstra(1)

    max_node, max_dist = 0, 0
    for i in range(1, n+1):
        if max_dist < distance[i]:
            max_node = i
            max_dist = distance[i]

    distance = dijkstra(max_node)
    distance = distance[1:]
    distance.sort(reverse=True)
    if distance[0] < n - 1:
        print(n-1)
    else:
        print(distance[0])