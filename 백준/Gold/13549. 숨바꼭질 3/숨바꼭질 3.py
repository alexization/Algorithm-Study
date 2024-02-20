import sys
from collections import deque

input = sys.stdin.readline

n, k = map(int, input().split())
visited = [-1] * 100001

q = deque()
q.append(n)
visited[n] = 0

while q:
    pos = q.popleft()

    if pos == k:
        break

    if 0 <= pos*2 <= 100000 and visited[pos*2] == -1:
        visited[pos*2] = visited[pos]
        q.appendleft(pos*2)
    if 0 <= pos - 1 <= 100000 and visited[pos-1] == -1:
        visited[pos-1] = visited[pos] + 1
        q.append(pos-1)
    if 0 <= pos + 1 <= 100000 and visited[pos+1] == -1:
        visited[pos+1] = visited[pos] + 1
        q.append(pos+1)

print(visited[k])