T = int(input())

for test_case in range(1, T+1):
    n = int(input())

    distance = 0
    speed = 0
    for _ in range(n):
        temp = list(map(int, input().split()))
        if temp[0] != 0:
            cmd, value = temp[0], temp[1]
        else:
            distance += speed
            continue
        
        if cmd == 1:
            speed += value
        else:
            speed -= value
            if speed < 0:
                speed = 0

        distance += speed
    
    print(f"#{test_case} {distance}")