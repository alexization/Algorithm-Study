from collections import deque
import sys

input = sys.stdin.readline

n = int(input())
data = deque()
for i in range(1, n+1):
    data.append(i)

while len(data) != 1:
    last_card = data.popleft()
    data.append(data.popleft())

print(list(data)[0])