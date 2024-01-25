import sys
input = sys.stdin.readline

n, m = map(int, input().split())
data = []
for _ in range(n):
    data.append(list(input().rstrip()))

b_start = [['B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'],
           ['W', 'B', 'W', 'B', 'W', 'B', 'W', 'B'],
           ['B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'],
           ['W', 'B', 'W', 'B', 'W', 'B', 'W', 'B'],
           ['B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'],
           ['W', 'B', 'W', 'B', 'W', 'B', 'W', 'B'],
           ['B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'],
           ['W', 'B', 'W', 'B', 'W', 'B', 'W', 'B']]

w_start = [['W', 'B', 'W', 'B', 'W', 'B', 'W', 'B'],
           ['B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'],
           ['W', 'B', 'W', 'B', 'W', 'B', 'W', 'B'],
           ['B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'],
           ['W', 'B', 'W', 'B', 'W', 'B', 'W', 'B'],
           ['B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'],
           ['W', 'B', 'W', 'B', 'W', 'B', 'W', 'B'],
           ['B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'],]

row_count = n - 8 + 1
col_count = m - 8 + 1

result = int(1e9)

for i in range(row_count):
    for j in range(col_count):
        b_count = 0
        w_count = 0
        for x in range(8):
            for y in range(8):
                if data[x+i][y+j] != b_start[x][y]:
                    b_count += 1
                if data[x+i][y+j] != w_start[x][y]:
                    w_count += 1
        if result > min(b_count, w_count):
                result = min(b_count, w_count)

print(result)