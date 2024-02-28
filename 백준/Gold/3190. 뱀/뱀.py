import sys
from collections import deque
input = sys.stdin.readline

n = int(input())
k = int(input())
graph = [[0] * (n+1) for _ in range(n+1)]

for _ in range(k):
    x, y = map(int, input().split())
    graph[x][y] = 1

l = int(input())
command = deque()
for _ in range(l):
    time, direction = input().split()
    command.append((int(time), direction))

# 동, 남, 서, 북
dx = [0, 1, 0, -1]
dy = [1, 0, -1, 0]

def turn(mode, direction):
    if mode == 'L':
        direction = (direction - 1) % 4
    else:
        direction = (direction + 1) % 4
    return direction

def move():
    snake = deque()
    snake.append((1, 1))
    direction = 0
    time = 0

    while True:
        x, y = snake[-1]
        nx = dx[direction] + x
        ny = dy[direction] + y

        if nx < 1 or ny < 1 or nx > n or ny > n:
            time += 1
            break

        if (nx, ny) in snake:
            time += 1
            break

        if graph[nx][ny] == 0:
            snake.popleft()
            snake.append((nx, ny))

        elif graph[nx][ny] == 1:
            graph[nx][ny] = 0
            snake.append((nx, ny))
            
        time += 1

        if command:
            if command[0][0] == time:
                direction = turn(command[0][1], direction)
                command.popleft()
    print(time)
move()