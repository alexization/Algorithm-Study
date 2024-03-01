import sys
from itertools import combinations
input = sys.stdin.readline

n = int(input())
graph = [list(map(int, input().split())) for _ in range(n)]

teams = [i for i in range(n)]

match = list(combinations(teams, (n//2)))
match_list = []
for i in range(len(match) // 2):
    match_list.append([match[i], match[-1-i]])

min_value = int(1e9)
for m in match_list:
    start = 0
    link = 0
    for i, j in list(combinations(m[0], 2)):
        start += graph[i][j]
        start += graph[j][i]
    
    for i, j in list(combinations(m[1], 2)):
        link += graph[i][j]
        link += graph[j][i]
    
    min_value = min(min_value, abs(start-link))

print(min_value)