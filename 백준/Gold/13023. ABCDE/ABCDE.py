import sys
input = sys.stdin.readline

n, m = map(int, input().split())
graph = [[] for _ in range(n)]
for _ in range(m):
    a, b = map(int, input().split())
    graph[a].append(b)
    graph[b].append(a)

def dfs(x, depth):
    global status
    visited[x] = True
    if depth == 5:
        status = True
        return
    
    for i in graph[x]:
        if visited[i] == True:
            continue
        
        visited[i] = True
        dfs(i, depth+1)
        visited[i] = False

    return

visited = [False] * n
status = False
for i in range(n):
    dfs(i, 1)
    visited[i] = False
    if status:
        break

if status:
    print(1)
else:
    print(0)