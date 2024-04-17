import sys
input = sys.stdin.readline

n = int(input())
size = 101
papers = []
for _ in range(n):
    papers.append(list(map(int, input().split())))

graph = [[0] * size for _ in range(size)]

for paper in papers:
    x, y = paper[0], paper[1]
    for i in range(10):
        for j in range(10):
            graph[x+i][y+j] = 1

dx = [-1, 0, 1, 0]
dy = [0, -1, 0, 1]

count = 0
for i in range(size):
    for j in range(size):
        if graph[i][j] == 1:
            for k in range(4):
                nx = i + dx[k]
                ny = j + dy[k]
                if graph[nx][ny] == 0:
                    count += 1

print(count)