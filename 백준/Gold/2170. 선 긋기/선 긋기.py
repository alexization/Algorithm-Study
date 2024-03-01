import sys
input = sys.stdin.readline

n = int(input())

lines = []
for _ in range(n):
    lines.append(list(map(int, input().split())))

lines.sort(key=lambda x : (x[0], x[1]))

max_line = lines[0][1]
start_line = lines[0][0]

result = 0
for line in lines:
    if max_line >= line[0]:
        if max_line < line[1]:
            max_line = line[1]
    else:
        result += (max_line - start_line)
        start_line = line[0]
        max_line = line[1]

result += (max_line - start_line)
print(result)