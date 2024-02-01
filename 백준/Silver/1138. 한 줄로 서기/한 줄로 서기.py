import sys

input = sys.stdin.readline

n = int(input())
data = list(map(int, input().split()))
result = [0 for _ in range(10)]

count = 1
for i in range(n):
    a = data[i] + 1
    for j in range(10):
        if a == 0:
            break
        if result[j] == 0:
            a -= 1
            position = j
    result[position] = count
    count += 1

result = list(map(str, result))
print(' '.join(result[:n]))