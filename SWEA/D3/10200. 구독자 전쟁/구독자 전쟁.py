T = int(input())

for test_case in range(1, T+1):
    n, a, b = map(int, input().split())

    maxValue = min(a, b)
    if a + b > n:
        minValue = (a+b) - n
    else:
        minValue = 0
    
    print(f"#{test_case} {maxValue} {minValue}")