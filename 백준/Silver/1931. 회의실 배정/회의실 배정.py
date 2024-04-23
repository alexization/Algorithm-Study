import sys
input = sys.stdin.readline

n = int(input())
meetings = []
for _ in range(n):
    s, e = map(int, input().split())
    meetings.append((s, e))

meetings.sort(key=lambda x: (x[1], x[0]))

endTime = meetings[0][1]
result = 1
for start, end in meetings[1:]:
    if endTime > start:
        continue
    endTime = end
    result += 1

print(result)