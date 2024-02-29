from collections import deque
import sys
input = sys.stdin.readline

n, m = map(int, input().split())

graph = [[] for _ in range(n+1)]
for _ in range(m):
    a, b = map(int, input().split())
    graph[b].append(a)

def bfs(start):
    q = deque()
    q.append(start)
    visited[start] = True

    count = 1
    while q:
        idx = q.popleft()

        for i in graph[idx]:
            if visited[i] == True:
                continue
            count += 1
            visited[i] = True
            q.append(i)
    return count

result = []
for i in range(1, n+1):
    visited = [False] * (n+1)
    result.append((bfs(i), i))

result.sort(key=lambda x: (-x[0], x[1]))
max_cnt = -1
final = []
for i in result:
    if i[0] > max_cnt:
        final = []
        max_cnt = i[0]
        final.append(str(i[1]))
    elif i[0] == max_cnt:
        final.append(str(i[1]))
    else:
        break

print(' '.join(final))