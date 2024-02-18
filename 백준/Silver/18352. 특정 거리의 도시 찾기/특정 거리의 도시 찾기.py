from collections import deque
from math import dist
import sys

input = sys.stdin.readline
n, m, k, x = map(int, input().split())

graph = [[] for _ in range(n+1)]
distance = [-1] * (n+1)
distance[x] = 0

for _ in range(m):
    a, b = map(int, input().split())
    graph[a].append(b)

def bfs(start):
    dq = deque()
    dq.append(start)

    while dq:
        a = dq.popleft()
        for i in graph[a]:
            if distance[i] == -1:
                distance[i] = distance[a] + 1
                dq.append(i)

bfs(x)

flag = False
for i in range(1, n+1):
    if k == distance[i]:
        flag = True
        print(i)

if flag == False:
    print(-1)