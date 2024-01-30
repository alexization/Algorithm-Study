import sys

input = sys.stdin.readline

n = int(input())

data = []
for i in range(n):
    x, y = map(int, input().split())
    data.append([x, y, 1])

for i in range(n):
    for j in range(n):
        if data[i][0] < data[j][0] and data[i][1] < data[j][1]:
            data[i][2] += 1

result = []
for i in data:
    result.append(str(i[2]))

print(' '.join(result))