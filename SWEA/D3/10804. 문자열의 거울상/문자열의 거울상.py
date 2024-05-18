T = int(input())

mirror = {'b':'d', 'd':'b', 'p':'q', 'q':'p'}

for test_case in range(1, T+1):
    arr = list(input())
    arr.reverse()
    result = ''
    for i in arr:
        result += mirror[i]
    
    print(f"#{test_case} {result}")