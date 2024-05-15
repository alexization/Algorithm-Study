T = int(input())

time = (11 * 24 * 60) + (11 * 60) + 11
for test_case in range(1, T+1):
    d, h, m = map(int, input().split())
    
    value = (d * 24 * 60) + (h * 60) + m
    result = value - time
    if result < 0:
        print(f"#{test_case} -1")
    else:
        print(f"#{test_case} {result}")