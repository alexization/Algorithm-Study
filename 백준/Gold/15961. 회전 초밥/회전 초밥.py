import sys
input = sys.stdin.readline

n, d, k, c = map(int, input().split())
plates = []
for _ in range(n):
    plates.append(int(input()))

check = [0] * (d+1)
check[c] = 1
count = 1

for i in range(k):
    value = plates[i]
    if not check[value]:
        count += 1
    
    check[value] += 1

maxValue = count

for i in range(n):
    start = plates[i]
    end = plates[(i+k)%n]

    check[start] -= 1
    if not check[start]:
        count -= 1
    if not check[end]:
        count += 1
    
    check[end] += 1
    maxValue = max(maxValue, count)

print(maxValue)