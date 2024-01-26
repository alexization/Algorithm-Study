N, K = map(int, input().split())
ball = N - (K+1) * K // 2

if ball < 0:
    print(-1)
else:
    if ball % K:
        print(K)
    else:
        print(K-1)