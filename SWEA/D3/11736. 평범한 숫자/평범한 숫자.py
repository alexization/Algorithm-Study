T = int(input())

for test_case in range(1, T+1):
    n = int(input())
    arr = list(map(int, input().split()))
    
    result = 0
    for i in range(n-2):
        minValue = min(arr[i:i+3])
        maxValue = max(arr[i:i+3])
        if arr[i+1] != minValue and arr[i+1] != maxValue:
            result += 1
        
    print(f"#{test_case} {result}")