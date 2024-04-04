from collections import deque
import sys
input = sys.stdin.readline

n, m, r = map(int, input().split())
graph = [[] for _ in range(n+1)]

for _ in range(m):
    u, v = map(int, input().split())
    graph[u].append(v)
    graph[v].append(u)

visited = [0] * (n+1)

def bfs(start):
    q = deque()
    q.append(start)
    count = 1
    visited[start] = count
    while q:
        now = q.popleft()
        temp = graph[now]
        temp.sort(reverse=True)
        for i in temp:
            if visited[i] != 0:
                continue
            count += 1
            visited[i] = count
            q.append(i)
        
bfs(r)
for i in visited[1:]:
    print(i)