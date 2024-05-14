T = int(input())

for test_case in range(1, T+1):
    n = int(input())
    temp = set()
    for _ in range(n):
        temp.add(input())

    arr = list(temp)
    result = []
    for value in arr:
        result.append((value, len(value)))
    
    result.sort(key=lambda x : (x[1], x[0]))

    print(f"#{test_case}")
    for value, length in result:
        print(value)