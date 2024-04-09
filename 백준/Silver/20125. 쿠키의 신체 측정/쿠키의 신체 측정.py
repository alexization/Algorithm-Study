import sys
input = sys.stdin.readline

n = int(input())
graph = [list(input().strip()) for _ in range(n)]

starList = []
for i in range(n):
    for j in range(n):
        if graph[i][j] == '*':
            starList.append((i, j))

head = starList[0]
heart = (starList[0][0] + 1, starList[0][1])

def left_arms(x, y):
    leftLength = 0
    count = 1
    while True:
        ny = y - count
        if ny < 0:
            return leftLength
        if graph[x][ny] != '*':
            return leftLength
        leftLength += 1
        count += 1

def right_arms(x, y):
    rightLength = 0
    count = 1
    while True:
        ny = y + count
        if ny >= n:
            return rightLength
        if graph[x][ny] != '*':
            return rightLength
        rightLength += 1
        count += 1

def waist(x, y):
    waistLength = 0
    count = 1
    while True:
        nx = x + count
        if nx >= n:
            return waistLength
        if graph[nx][y] != '*':
            return waistLength, nx, y
        waistLength += 1
        count += 1

def legLength(x, y):
    legLength = 1
    count = 1
    while True:
        nx = x + count
        if nx >= n:
            return legLength
        if graph[nx][y] != '*':
            return legLength
        legLength += 1
        count += 1

leftLength = left_arms(heart[0], heart[1])
rightLength = right_arms(heart[0], heart[1])
waistLength, legX, legY = waist(heart[0], heart[1])
leftLegLength = legLength(legX, legY-1)
rightLegLength = legLength(legX, legY+1)

print(heart[0] + 1, heart[1] + 1)
print(leftLength, rightLength, waistLength, leftLegLength, rightLegLength)