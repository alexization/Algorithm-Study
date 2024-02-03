import sys
sys.setrecursionlimit(10**7)

input = sys.stdin.readline

def dfs(x):
    for i in range(n):
        if visited[i] == 0 and graph[x][i] == 1:
            visited[i] = 1
            dfs(i)

n = int(input())
graph = []
for _ in range(n):
    graph.append(list(map(int, input().split())))

for i in range(n):
    visited = [0] * n
    dfs(i)
    print(*visited)