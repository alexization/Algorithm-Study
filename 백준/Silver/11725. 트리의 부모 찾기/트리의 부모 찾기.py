from collections import deque
import sys
input = sys.stdin.readline

n = int(input())
graph = [[] for _ in range(n+1)]
result = [-1] * (n+1)

for _ in range(n-1):
    a, b = map(int, input().split())
    graph[a].append(b)
    graph[b].append(a)

visited = [False] * (n+1)
def bfs(start):
    q = deque()
    q.append(start)
    visited[start] = True

    while q:
        idx = q.popleft()
        for i in graph[idx]:
            if visited[i] == False:
                result[i] = idx
                visited[i] = True
                q.append(i)

bfs(1)
for i in result[2:]:
    print(i)
