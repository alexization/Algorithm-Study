from collections import deque
import sys

input = sys.stdin.readline

n, k = map(int, input().split())

data = deque()
for i in range(1, n+1):
    data.append(i)

result = []
while data:
    for i in range(k):
        data.append(data.popleft())
    result.append(str(data.pop()))

print('<' + ', '.join(result) + '>')