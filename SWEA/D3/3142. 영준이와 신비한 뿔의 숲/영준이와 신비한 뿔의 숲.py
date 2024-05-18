T = int(input())

for test_case in range(1, T+1):
    n, m = map(int, input().split())

    print(f"#{test_case} {2*m-n} {n-m}")