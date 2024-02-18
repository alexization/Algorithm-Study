import sys
input = sys.stdin.readline

n = int(input())
weights = []
for _ in range(n):
    weights.append(int(input()))

weights.sort()

maxWeight = -1
for i in range(n):
    w = weights[i] * (n-i)
    if w > maxWeight:
        maxWeight = w

print(maxWeight)