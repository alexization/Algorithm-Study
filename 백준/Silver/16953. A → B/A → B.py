from collections import deque

a, b = map(int, input().split())
INF = int(1e9)

result = -1
def bfs(start):
    global result
    q = deque()
    q.append((start, 1))

    while q:
        value, count = q.popleft()
        if value > b:
            continue
        if value == b:
            result = count
            break

        q.append((value*2, count+1))
        q.append((int(str(value)+'1'), count+1))

bfs(a)
print(result)