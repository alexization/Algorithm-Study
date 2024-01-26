import sys

input = sys.stdin.readline

n, m = map(int, input().split())
data = list(map(int, input().split()))
sum_data = []
sum = 0

for i in range(n):
    sum += data[i]
    sum_data.append(sum)

for i in range(m):
    i, j = map(int, input().split())

    if i == j:
        print(data[i-1])
        continue
    if i == 1:
        print(sum_data[j-1])
        continue

    print(sum_data[j-1]-sum_data[i-2])
