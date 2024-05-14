T = int(input())
for test_case in range(1, T+1):
    fm, fd, sm, day = map(int, input().split())

    dates = {1:31, 2:28, 3:31, 4:30, 5:31, 6:30, 7:31, 8:31, 9:30, 10:31, 11:30, 12:31}

    result = 0
    while sm != fm:
        sm -= 1
        day += dates[sm]
    
    result += day - fd + 1

    print(f"#{test_case} {result}")