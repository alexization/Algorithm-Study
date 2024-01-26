import sys

input = sys.stdin.readline

n, k = map(int, input().split())
data = list(input().rstrip())

count = 0
for i in range(n):
    if data[i] == 'H':
        continue
    elif data[i] == 'P':
        for j in range(i-k, i+k+1):
            if j >= 0 and j < n:
                if data[j] == 'H':
                    count += 1
                    data[j] = 'E'
                    break

print(count)