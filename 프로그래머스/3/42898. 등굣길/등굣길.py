def solution(m, n, puddles):
    answer = 0
    graph = [[0 for _ in range(m)] for _ in range(n)]
    
    for p in puddles:
        y, x = p[0], p[1]
        graph[x-1][y-1] = -1
    
    graph[0][0] = 1
    for i in range(1, m):
        if graph[0][i] == -1 or graph[0][i-1] == 0:
            graph[0][i] = 0
        else:
            graph[0][i] = 1
    for i in range(1, n):
        if graph[i][0] == -1 or graph[i-1][0] == 0:
            graph[i][0] = 0
        else:
            graph[i][0] = 1
        
    for i in range(1, n):
        for j in range(1, m):
            if graph[i][j] == -1:
                graph[i][j] = 0
                continue
            graph[i][j] = graph[i-1][j] + graph[i][j-1]
        
    answer = (graph[n-1][m-1]) % 1000000007
    return answer