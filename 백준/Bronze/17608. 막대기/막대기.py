import sys

input = sys.stdin.readline

n = int(input())
sticks = []
for _ in range(n):
    sticks.append(int(input()))

count = 1
max_height = sticks[-1]

for i in range(n-2, -1, -1):
    if sticks[i] > max_height:
        max_height = sticks[i]
        count += 1

print(count)