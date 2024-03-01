import sys
input = sys.stdin.readline

def find_parent(parent, x):
    if parent[x] != x:
        return find_parent(parent, parent[x])
    return x

def union_parent(parent, a, b):
    a = find_parent(parent, a)
    b = find_parent(parent, b)
    parent[b]= a

while True:
    n, m = map(int, input().split())
    if n == 0 and m == 0:
        break
    edges = []
    total_cost = 0
    for _ in range(m):
        a, b, c = map(int, input().split())
        edges.append((c, a, b))
        total_cost += c

    parent = [i for i in range(n)]
    edges.sort()

    result = 0
    for edge in edges:
        cost, a, b = edge
        if find_parent(parent, a) != find_parent(parent, b):
            union_parent(parent, a, b)
            result += cost

    print(total_cost - result)