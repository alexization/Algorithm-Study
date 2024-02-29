import sys
from collections import deque
input = sys.stdin.readline

t = int(input())

def distance(x1, y1, x2, y2):
    return (abs(x2-x1) + abs(y2-y1))

def bfs(x, y):
    q = deque()
    q.append((x, y))

    while q:
        x, y = q.popleft()
        if distance(x, y, fx, fy) <= 1000:
            print('happy')
            return
        
        for i in range(n):
            if visited[i] == False:
                sx, sy = store[i]
                if distance(x, y, sx, sy) <= 1000:
                    visited[i] = True
                    q.append((sx, sy))
    print('sad')
    return

for _ in range(t):
    n = int(input())
    
    hx, hy = map(int, input().split())
    store = deque()
    for _ in range(n):
        x, y = map(int, input().split())
        store.append((x, y))
    fx, fy = map(int, input().split())
    visited = [False] * (n)

    bfs(hx, hy)
