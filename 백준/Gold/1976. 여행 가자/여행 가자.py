import sys
input = sys.stdin.readline

def find_parent(parent, x):
    if parent[x] != x:
        return find_parent(parent, parent[x])
    return x

def union_parent(parent, a, b):
    a = find_parent(parent, a)
    b = find_parent(parent, b)

    if a < b:
        parent[b] = a
    else:
        parent[a] = b

n = int(input())
m = int(input())

graph = [list(map(int, input().split())) for _ in range(n)]

array = [[] for _ in range(n+1)]
for idx, g in enumerate(graph, start=1):
    for i, value in enumerate(g, start=1):
        if value == 1:
            array[idx].append(i)

plan = list(map(int, input().split()))
parent = [0] * (n+1)

for i in range(1, n+1):
    parent[i] = i

for idx, a in enumerate(array):
    for i in a:
        union_parent(parent, idx, i)

find = set()
for i in plan:
    find.add(find_parent(parent, i))

if len(find) == 1:
    print('YES')
else:
    print('NO')