from collections import deque

def rotate(number, dir):
    if dir == 1:
        number.appendleft(number.pop())

    else:
        number.append(number.popleft())

one = deque(map(int, input()))
two = deque(map(int, input()))
three = deque(map(int, input()))
four = deque(map(int, input()))

numDict = {1:one, 2:two, 3:three, 4:four}
order = [[], [[0, 1, 0, -1, 2, 6], [1, 2, 0, 1, 2, 6], [2, 3, 0, -1, 2, 6]], [[0, -1, 1, -1, 6, 2], [0, 1, 0, -1, 2, 6], [1, 2, 0, 1, 2, 6]],
         [[0, 1, 1, -1, 2, 6], [0, -1, 0, -1, 6, 2], [-1, -2, 0, 1, 6, 2]], [[0, -1, 0, -1, 6, 2], [-1, -2, 0, 1, 6, 2], [-2, -3, 0, -1, 6, 2]]]

n = int(input())
for _ in range(n):
    number, dir = map(int, input().split())

    next = []
    next.append((numDict[number], dir))
    for i in order[number]:
        if numDict[number+i[0]][i[4]] != numDict[number+i[1]][i[5]]:
            if i[3] == 1:
                next.append((numDict[number+i[1]], dir))
            else:
                next.append((numDict[number+i[1]], -dir))
        else:
            if i[2] == 0:
                break

    for n in next:
        rotate(n[0], n[1])

result = one[0] + two[0] * 2 + three[0] * 4 + four[0] * 8
print(result)