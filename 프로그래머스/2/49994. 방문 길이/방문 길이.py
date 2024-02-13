def solution(dirs):
    answer = 0
    array = [[[-1 for _ in range(4)] for _ in range(11)] for _ in range(11)]
    x, y = 5, 5
    count = 0
    for dir in dirs:
        if dir == 'U' and x-1 >= 0:
            x -= 1
            if array[x][y][0] == -1:
                count += 1
                array[x][y][0] = 0
                array[x+1][y][1] = 0
        elif dir == 'D' and x+1 <= 10:
            x += 1
            if array[x][y][1] == -1:
                count += 1
                array[x-1][y][0] = 0
                array[x][y][1] = 0
        elif dir == 'L' and y-1 >= 0:
            y -= 1
            if array[x][y][2] == -1:
                count += 1
                array[x][y+1][3] = 0
                array[x][y][2] = 0
        elif dir == 'R' and y+1 <= 10:
            y += 1
            if array[x][y][3] == -1:
                count += 1
                array[x][y-1][2] = 0
                array[x][y][3] = 0

    answer = count
    return answer