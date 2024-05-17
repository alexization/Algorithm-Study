T = int(input())

for test_case in range(1, T+1):
    arr = list(map(int, input()))

    if arr[-1] % 2 == 0:
        print(f"#{test_case} Even")
    else:
        print(f"#{test_case} Odd")