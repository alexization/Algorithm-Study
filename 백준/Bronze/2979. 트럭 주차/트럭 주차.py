import sys

input = sys.stdin.readline

a, b, c = map(int, input().split())

data = []

for _ in range(3):
    start, end = map(int, input().split())
    data.append([start, end, 0])

cost, truck, time = 0, 0, 1

while time < 100:
    for i in range(3):
        if data[i][0] <= time < data[i][1]:
            if data[i][2] == 0:
                truck += 1
                data[i][2] = 1
        else:
            if data[i][2] == 1:
                truck -= 1
                data[i][2] = 0

    if truck == 1:
        cost += a
    elif truck == 2:
        cost += b * 2
    elif truck == 3:
        cost += c * 3

    time += 1

print(cost)
