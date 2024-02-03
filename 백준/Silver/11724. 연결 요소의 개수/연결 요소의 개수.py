import sys
sys.setrecursionlimit(10**7)

input = sys.stdin.readline

def dfs(x):
    visited[x] = True
    for g in graph[x]:
        if visited[g] == False:
            dfs(g)

n, m = map(int, input().split())
graph = [[] for _ in range(n+1)]

for _ in range(m):
    u, v = map(int, input().split())
    graph[u].append(v)
    graph[v].append(u)

visited = [False] * (n+1)

count = 0
for i in range(1, n+1):
    if visited[i] == False:
        count += 1
        dfs(i)

print(count)