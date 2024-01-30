import sys

input = sys.stdin.readline

n, k = map(int, input().split())
data = []

for i in range(1, n+1):
    c, x, y, z = map(int, input().split())
    data.append([c, x, y, z])

data.sort(key= lambda x : (-x[1], -x[2], -x[3]))

count = 1
common = 1

if k == data[0][0]:
    print(1)

else:
    g, s, d = data[0][1], data[0][2], data[0][3]
    for i in range(1, len(data)):
        if data[i][1] == g and data[i][2] == s and data[i][3] == d:
            common += 1
        else:
            count += common
            common = 1
            g, s, d = data[i][1], data[i][2], data[i][3]
        
        if k == data[i][0]:
            print(count)
            break