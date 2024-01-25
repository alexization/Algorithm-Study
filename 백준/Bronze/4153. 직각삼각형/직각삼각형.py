import sys
input = sys.stdin.readline

data = []

while True:
    data.append(list(map(int, input().split())))
    
    if data[-1][0] == 0 and data[-1][1] == 0 and data[-1][2] == 0:
        data.pop()
        break

result = []
for i in range(len(data)):
    data[i].sort()
    if data[i][0]**2 + data[i][1]**2 == data[i][2]**2:
        result.append('right')
    else:
        result.append('wrong')

print('\n'.join(result))