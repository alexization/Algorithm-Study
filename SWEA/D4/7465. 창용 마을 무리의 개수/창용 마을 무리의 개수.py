from collections import deque

def bfs(start):
    q = deque()
    q.append(start)
    visited[start] = True

    while q:
        next = q.popleft()
        for i in graph[next]:
            if visited[i] == False:
                visited[i] = True
                q.append(i)

T = int(input())

for test_case in range(1, T+1):
    n, m = map(int, input().split())
    graph = [[] for _ in range(n+1)]

    for _ in range(m):
        a, b = map(int, input().split())
        graph[a].append(b)
        graph[b].append(a)
    
    visited = [False] * (n+1)

    result = 0
    for i in range(1, n+1):
        if visited[i] == False:
            bfs(i)
            result += 1
    
    print(f"#{test_case} {result}")