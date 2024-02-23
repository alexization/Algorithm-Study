import sys
input = sys.stdin.readline

n = int(input())
lines = list(map(int, input().split()))
prices = list(map(int, input().split()))

result = 0

distance = 0
min_price = prices[0]
for i in range(n-1):
    if min_price <= prices[i]:
        distance += lines[i]
    else:
        result += distance * min_price
        distance = lines[i]
        min_price = prices[i]

result += distance * min_price

print(result)