import sys

input = sys.stdin.readline

h, w = map(int, input().split())

graph = [list(input().strip()) for _ in range(h)]
result = [[-1 for _ in range(w)] for _ in range(h)]

for i in range(h):
    for j in range(w):
        if graph[i][j] == 'c':
            result[i][j] = 0

for i in range(h):
    for j in range(w-1):
        if result[i][j] != -1:
            if result[i][j+1] != 0:
                result[i][j+1] = result[i][j] + 1

for i in result:
    str_result  = list(map(str, i))
    print(' '.join(str_result))