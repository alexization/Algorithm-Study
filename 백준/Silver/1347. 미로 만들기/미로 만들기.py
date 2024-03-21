import sys
input = sys.stdin.readline

n = int(input())
operations = list(input().strip())

status = 0
dx = [1, 0, -1, 0]
dy = [0, -1, 0, 1]

graph = [['#'] * 101 for _ in range(101)]
x, y = 50, 50
graph[x][y] = '.'

for o in operations:
    if o == 'R':
        status = (status + 1) % 4
    elif o == 'L':
        status = (status - 1) % 4
    else:
        x += dx[status]
        y += dy[status]
        graph[x][y] = '.'

x1, y1, x2, y2 = 100, 100, 0, 0
for i in range(101):
    for j in range(101):
        if graph[i][j] == '.':
            if x1 > i:
                x1 = i
            if y1 > j:
                y1 = j
            if x2 < i:
                x2 = i
            if y2 < j:
                y2 = j

for i in range(x1, x2+1):
    for j in range(y1, y2+1):
        print(graph[i][j], end='')
    print()