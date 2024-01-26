from collections import deque
from math import ceil

n = int(input())

data = deque()

for i in range(1, n+1):
    data.append(i)

while len(data) != 1:
    count = ceil(len(data)/2)

    if len(data) % 2 == 0:
        for i in range(count):
            data.popleft()
            data.append(data.popleft())
    else:
        for i in range(count):
            data.popleft()
            data.append(data.popleft())
        data.append(data.popleft())
print(data[0])
