import heapq
import sys
input = sys.stdin.readline
INF = int(1e9)

dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]

def dijkstra():
    q = []
    heapq.heappush(q, (graph[0][0], 0, 0))
    distance[0][0] = 0

    while q:
        cost, x, y = heapq.heappop(q)

        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]

            if nx >= n or ny >= n or nx < 0 or ny < 0:
                continue

            newCost = cost + graph[nx][ny]

            if newCost < distance[nx][ny]:
                distance[nx][ny] = newCost
                heapq.heappush(q, (newCost, nx, ny))

count = 1
while True:
    n = int(input())
    if n == 0:
        break
    
    graph = [list(map(int, input().split())) for _ in range(n)]
    distance = [[INF] * n for _ in range(n)]
    dijkstra()
    print(f"Problem {count}: {distance[n-1][n-1]}")
    count += 1