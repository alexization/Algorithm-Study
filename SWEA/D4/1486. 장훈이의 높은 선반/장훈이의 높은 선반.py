def dfs(sumValue, idx):
    global minValue

    if sumValue >= b:
        minValue = min(minValue, sumValue)
        return
    
    for i in range(idx, n):
        next = sumValue + arr[i]
        dfs(next, i+1)
        next = sumValue - arr[i]

T = int(input())

for test_case in range(1, T+1):
    n, b = map(int, input().split())
    arr = list(map(int, input().split()))

    minValue = int(1e9)
    dfs(0, 0)

    print(f"#{test_case} {minValue - b}")