import sys
input = sys.stdin.readline

graph = [[0] * 101 for _ in range(101)]

n = int(input())
papers = []
for _ in range(n):
    papers.append(list(map(int, input().split())))

for paper in papers:
    x, y = paper[0], paper[1]
    for i in range(x, x+10):
        for j in range(y, y + 10):
            graph[i][j] = 1

count = 0
for i in range(101):
    for j in range(101):
        if graph[i][j] == 1:
            count+=1

print(count)