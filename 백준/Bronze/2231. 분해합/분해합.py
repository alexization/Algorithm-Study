import sys

input = sys.stdin.readline

n = int(input())
out = []

for i in range(1, n+1):
    result = i
    data = list(str(i))
    for j in data:
        result += int(j)

    if result == n:
        out.append(i)

if out:
    print(out[0])
else:
    print(0)
