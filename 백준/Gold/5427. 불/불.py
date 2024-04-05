from collections import deque
import sys
input = sys.stdin.readline

dx = [-1, 0, 1, 0]
dy = [0, -1, 0, 1]

def bfs(person, fires):
    while True:
        nextPerson = deque()
        nextFires = deque()
        while person:
            x, y = person.popleft()
            if graph[x][y] == '*':
                continue
            if x == 0 or y == 0 or x == m-1 or y == n-1:
                return graph[x][y]
            
            for i in range(4):
                nx = x + dx[i]
                ny = y + dy[i]
                if 0 <= nx < m and 0 <= ny < n:
                    if graph[nx][ny] == '.':
                        graph[nx][ny] = graph[x][y] + 1
                        nextPerson.append((nx, ny))
        if len(nextPerson) == 0:
            return -1
        
        person = deque([i[:] for i in nextPerson])
        while fires:
            x, y = fires.popleft()
            for i in range(4):
                nx = x + dx[i]
                ny = y + dy[i]
                if 0 <= nx < m and 0 <= ny < n:
                    if graph[nx][ny] != '#' and graph[nx][ny] != '*':
                        graph[nx][ny] = '*'
                        nextFires.append((nx, ny))
        fires = deque([i[:] for i in nextFires])

t = int(input())
for _ in range(t):
    n, m = map(int, input().split())
    graph = [list(input().strip()) for _ in range(m)]

    person = deque()
    fires = deque()
    for i in range(m):
        for j in range(n):
            if graph[i][j] == '@':
                person.append((i, j))
                graph[i][j] = 1

            elif graph[i][j] == '*':
                fires.append((i, j))

    value = bfs(person, fires)
    if value == -1:
        print('IMPOSSIBLE')
    else:
        print(value)