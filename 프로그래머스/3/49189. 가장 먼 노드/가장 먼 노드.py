import heapq

def dijkstra(start, distance, graph):
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
    
    
def solution(n, edge):
    INF = int(1e9)
    graph = [[] for _ in range(len(edge) + 1)]
    distance = [INF] * (n+1)
    
    for e in edge:
        graph[e[0]].append((e[1], 1))
        graph[e[1]].append((e[0], 1))
    dijkstra(1, distance, graph)
    
    max_value = -1
    count = 0
    for i in range(1, n+1):
        if max_value < distance[i]:
            count = 1
            max_value = distance[i]
        elif max_value == distance[i]:
            count += 1
            
    return count