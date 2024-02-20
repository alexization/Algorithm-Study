from collections import deque
import sys
input = sys.stdin.readline

n, k = map(int, input().split())
visited = [-1] * 100001

q = deque()

q.append((n, 0))
visited[n] = 0

countDict = dict()
while q:
    idx, count = q.popleft()
    if idx == k:
        if count not in countDict:
            countDict[count] = 1
        else:
            countDict[count] += 1
        continue

    for i in [idx*2, idx-1, idx+1]:
        if 0 <= i <= 100000 and (visited[i] == -1 or visited[i] == visited[idx] + 1):
            visited[i] = visited[idx] + 1
            q.append((i, count+1))

for time, count in countDict.items():
    print(time)
    print(count)