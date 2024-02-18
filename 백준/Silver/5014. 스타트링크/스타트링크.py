from collections import deque
import sys
input = sys.stdin.readline

f, s, g, u, d = map(int, input().split())

visited = [False] * (f+1)
q = deque()

count = 0
result = 0

q.append((s, 0))

while q:
    idx, count = q.popleft()
    if visited[idx] == True:
        continue
    if idx == g:
        result = count
        break

    visited[idx] = True

    count += 1
    if idx + u <= f:
        q.append((idx+u, count))

    if idx - d > 0:
        q.append((idx-d, count))

if s == g:
    print(0)
else:
    if result == 0:
        print("use the stairs")
    else:
        print(result)