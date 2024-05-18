T = int(input())

for test_case in range(1, T+1):
    fh, fm, lh, lm = map(int, input().split())
    
    plusHour = (fm+lm) // 60
    nextMin = (fm+lm) % 60
    
    nextHour = (plusHour + fh + lh) % 12
    if nextHour == 0:
        nextHour = 12
    
    print(f"#{test_case} {nextHour} {nextMin}")