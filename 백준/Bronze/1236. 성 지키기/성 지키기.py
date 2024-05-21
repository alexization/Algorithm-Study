n, m = map(int, input().split())
graph = [list(input()) for _ in range(n)]

row = 0
for i in range(n):
    rowStatus = True
    for j in range(m):
        if graph[i][j] == 'X':
            rowStatus = False
    if rowStatus:
        row += 1

col = 0
for i in range(m):
    colStatus = True
    for j in range(n):
        if graph[j][i] == 'X':
            colStatus = False

    if colStatus:
        col += 1

result = max(col, row)
print(result)