import sys
from itertools import combinations

input = sys.stdin.readline

n, k = map(int, input().split())

house = []
for i in range(n):
    x, y = map(int, input().split())
    house.append([x, y])

result = int(1e9)

for comb in combinations(range(n), k):
    
    max_dist = 0
    for i in range(n):
        min_dist = int(1e9)
        for c in comb:
            dist = abs(house[i][0] - house[c][0]) + abs(house[i][1] - house[c][1])
            min_dist = min(dist, min_dist)
        
        max_dist = max(min_dist, max_dist)

    result = min(result, max_dist)
    
print(result)