from collections import deque
import sys
input = sys.stdin.readline

def bfs(start):
    q = deque()
    visited[start][0] = True
    visited[start][1] = 0
    q.append((start, 0))

    while q:
        x, color = q.popleft()
        if color == 0:
            nc = 1
        else:
            nc = 0

        for i in graph[x]:
            if visited[i][0] == False:
                visited[i][0] = True
                visited[i][1] = nc
                q.append((i, nc))
            else:
                if color == visited[i][1]:
                    return False
    
    return True

t = int(input())
for _ in range(t):
    v, e = map(int ,input().split())
    graph = [[] for _ in range(v+1)]
    visited = [[False, -1] for _ in range(v+1)]

    for _ in range(e):
        a, b = map(int, input().split())
        graph[a].append(b)
        graph[b].append(a)
    
    status = True
    for i in range(1, v+1):
        if visited[i][0] == False:
            if bfs(i) == False:
                status = False
                break

    if status:
        print("YES")
    else:
        print("NO")