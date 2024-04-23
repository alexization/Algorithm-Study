a, b, c = map(int, input().split())

def cal(a, b):
    if b == 1:
        return a % c
    
    result = cal(a, b // 2)

    if b % 2 == 0:
        return (result * result) % c
    else:
        return (result * result) * a % c

print(cal(a, b))