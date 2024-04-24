import sys
input = sys.stdin.readline

n, m = map(int, input().split())
arr = list(map(int, input().split()))

head = 0
tail = 0
value = 0

result = 0

while True:
    if value < m:
        if head == n:
            break
        value += arr[head]
        head += 1

    else:
        value -= arr[tail]
        tail += 1

    if value == m:
        result += 1

print(result)