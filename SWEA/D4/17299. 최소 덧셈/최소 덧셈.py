T = int(input())

for test_case in range(1, T+1):
    arr = list(input())

    minValue = int(1e9)
    for i in range(1, len(arr)):
        left = int(''.join(arr[0:i]))
        right = int(''.join(arr[i:]))

        minValue = min(minValue, left+right)

    print(f"#{test_case} {minValue}")