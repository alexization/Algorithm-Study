def check(w, b, r):
    count = 0

    idx = 0
    for i in range(w):
        for j in range(m):
            if graph[idx+i][j] != 'W':
                count += 1
    idx += w
    for i in range(b):
        for j in range(m):
            if graph[idx+i][j] != 'B':
                count += 1

    idx += b
    for i in range(r):
        for j in range(m):
            if graph[idx+i][j] != 'R':
                count += 1

    return count

T = int(input())

for test_case in range(1, T+1):
    n, m = map(int, input().split())
    graph = [list(input()) for _ in range(n)]

    minValue = int(1e9)
    maxScope = n - 3
    for i in range(1, maxScope + 2):
        for j in range(1, maxScope + 2):
            for k in range(1, maxScope + 2):
                if (i + j + k) == n:
                    minValue = min(minValue, check(i,j,k))
    
    print(f"#{test_case} {minValue}")