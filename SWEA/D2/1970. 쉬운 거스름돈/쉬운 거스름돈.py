T = int(input())
for test_case in range(1, T+1):
    cost = int(input())
    moneys = [50000, 10000, 5000, 1000, 500, 100, 50, 10]

    result = [0, 0, 0, 0, 0, 0, 0, 0]
    for i in range(8):
        if cost >= moneys[i]:
            result[i] = (cost // moneys[i])
            cost = cost % moneys[i]
        
        if cost == 0:
            break
    
    print(f"#{test_case}")
    print(*result)