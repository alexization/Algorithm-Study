from collections import deque
def solution(m, n, board):
    answer = 0
    graph = []
    
    for i in range(len(board)):
            graph.append(list(board[i]))
            
    while True:
        after = [[0 for _ in range(n)] for _ in range(m)]
        status = False
        for i in range(m-1):
            for j in range(n-1):
                if graph[i][j] == ' ':
                    continue
                    
                if graph[i][j] == graph[i][j+1] == graph[i+1][j] == graph[i+1][j+1]:
                    after[i][j], after[i][j+1], after[i+1][j], after[i+1][j+1] = -1, -1, -1, -1
                    status = True
                    
        if status == False:
            break
        
        d = deque()
        for i in range(n):
            for j in range(m):
                if after[j][i] != -1:
                    d.append(graph[j][i])
                else:
                    answer += 1

            for j in range(m-1, -1, -1):
                if len(d):
                    value = d.pop()
                    graph[j][i] = value
                else:
                    graph[j][i] = ' '
        
    return answer