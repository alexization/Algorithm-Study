def solution(x, y, n):
    answer = 0
    INF = int(1e9)
    dp = [INF for _ in range(y+1)]
    
    dp[x] = 0
    
    for i in range(x, y+1):
        dp[i] = min(dp[i-n] + 1, dp[i])
        if i % 2 == 0:
            dp[i] = min(dp[i//2] + 1, dp[i])
        if i % 3 == 0:
            dp[i] = min(dp[i//3] + 1, dp[i])
    
    if dp[y] == INF:
        answer = -1
    else:
        answer = dp[y]
    return answer