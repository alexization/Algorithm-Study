def solution(n, computers):
    answer = 0
    for i in range(n):
        computers[i][i] = 0
    
    visited = [False for _ in range(n)]
    
    def dfs(x):
        if visited[x] == True:
            return
        visited[x] = True
        
        for i in range(n):
            if computers[x][i] == 1:
                dfs(i)
        
    for i in range(n):
        if visited[i] == False:
            dfs(i)
            answer += 1
    
    return answer