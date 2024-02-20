from collections import deque
import sys
input = sys.stdin.readline

n, k = map(int, input().split())
visited = [-1] * 100001
parent = [0] * 100001

for i in range(100001):
    parent[i] = i

q = deque()

q.append(n)
visited[n] = 0

while q:
    idx = q.popleft()

    for i in [idx*2, idx-1, idx+1]:
        if 0 <= i <= 100000 and (visited[i] == -1 or visited[i] == visited[idx] + 1):
            visited[i] = visited[idx] + 1
            parent[i] = idx
            q.append(i)

result = deque()
result.append(str(k))
idx = parent[k]

if k != n:
    while True:
        if idx == n:
            result.appendleft(str(idx))
            break
        else:
            result.appendleft(str(idx))

        idx = parent[idx]

print(visited[k])
print(' '.join(result))