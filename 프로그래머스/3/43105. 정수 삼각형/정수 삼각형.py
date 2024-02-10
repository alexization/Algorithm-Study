def solution(triangle):
    answer = 0
    len_tri = len(triangle)
    dp = [[-1 for _ in range(len(triangle))] for _ in range(len_tri)]
    
    dp[0][0] = triangle[0][0]
    
    for i in range(1, len_tri):
        dp[i][0] = dp[i-1][0] + triangle[i][0]
        dp[i][i] = dp[i-1][i] + triangle[i][i]
        
        for j in range(1, i+1):
            dp[i][j] = max(dp[i-1][j-1], dp[i-1][j]) + triangle[i][j]
    
    answer = max(dp[len_tri-1])
    return answer