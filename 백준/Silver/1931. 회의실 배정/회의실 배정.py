import sys

input = sys.stdin.readline

n = int(input())
data = []

for i in range(n):
    s, e = map(int, input().split())
    data.append([s, e])

data.sort(key=lambda x: [x[1], x[0]])

count = 1
end_time = data[0][1]
for i in range(1, n):
    if end_time > data[i][0]:
        continue

    end_time = data[i][1]
    count += 1

print(count)
