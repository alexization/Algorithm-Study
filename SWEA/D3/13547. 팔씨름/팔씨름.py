T = int(input())

for test_case in range(1, T+1):
    arr = list(input())
    
    total = 15 - len(arr)
    count = 0
    for i in arr:
        if i == 'o':
            count += 1
    
    count += total
    if count >= 8:
        print(f"#{test_case} YES")
    else:
        print(f"#{test_case} NO")