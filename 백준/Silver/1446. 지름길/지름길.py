import sys
input = sys.stdin.readline
INF = int(1e9)

n, d = map(int, input().split())

distance = [i for i in range(d+1)]
array = []
for _ in range(n):
    a, b, c = map(int, input().split())
    if b > d:
        continue
    if abs(b - a) < c:
        continue
    array.append([a, b, c])

for i in range(d+1):
    distance[i] = min(distance[i], distance[i-1]+1)
    for start, end, dist in array:
        if distance[end] > distance[start] + dist:
            distance[end] = distance[start] + dist
    
print(distance[d])