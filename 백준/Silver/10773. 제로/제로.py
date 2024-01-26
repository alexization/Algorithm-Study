import sys

input = sys.stdin.readline

k = int(input())
data = []

for _ in range(k):
    x = int(input())

    if x == 0 and len(data) != 0:
        data.pop()
        continue

    data.append(x)

sum = 0
for i in data:
    sum += i

print(sum)