a, b, n = map(int, input().split())

for _ in range(n):
    a = a % b
    a *= 10
    result = a // b

print(result)