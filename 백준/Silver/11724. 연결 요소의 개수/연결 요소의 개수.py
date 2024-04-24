from collections import deque
import sys
input = sys.stdin.readline

n, m = map(int, input().split())
graph = [[] for _ in range(n+1)]

def bfs(x):
    q = deque()
    visited[x] = True
    q.append(x)
    while q:
        x = q.popleft()
        for i in graph[x]:
            if visited[i] == False:
                visited[i] = True
                q.append(i)

visited = [False] * (n+1)

for _ in range(m):
    a, b = map(int, input().split())
    graph[a].append(b)
    graph[b].append(a)
    
count = 0
for i in range(1, n+1):
    if visited[i] == False:
        count +=1 
        bfs(i)

print(count)