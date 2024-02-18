import sys
input = sys.stdin.readline

n, m = map(int, input().split())
j = int(input())

leftPos = 1
rightPos = 1 + (m-1)
move = 0

for _ in range(j):
    i = int(input())
    while True:
        if leftPos <= i <= rightPos:
            break
    
        if i > rightPos:
            leftPos += 1
            rightPos += 1
            move += 1
    
        elif i < leftPos:
            leftPos -= 1
            rightPos -= 1
            move += 1

print(move)