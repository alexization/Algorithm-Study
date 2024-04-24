import sys
input = sys.stdin.readline

n = int(input())
arr = list(map(int, input().split()))
x = int(input())

arr.sort()

head, tail, count = n-1, 0, 0
value = arr[head] + arr[tail]

while tail < head:
    if x == value:
        count += 1

    if x <= value:
        value -= arr[head]
        head -= 1
        value += arr[head]
    else:
        value -= arr[tail]
        tail += 1
        value += arr[tail]

print(count)