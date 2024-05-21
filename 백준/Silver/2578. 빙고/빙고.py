def bingo_check():
    leftDiaCount = 0
    rightDiaCount = 0
    bingo = 0

    for i in range(5):
        colCount = 0
        rowCount = 0
        for j in range(5):
            # 오른쪽 아랫 대각선 빙고 체크
            if i == j and status[i][j] == True:
                leftDiaCount += 1
            # 왼쪽 아랫 대각선 빙고 체크
            if i == 4 - j and status[i][j] == True:
                rightDiaCount += 1
            # 가로 빙고 체크
            if status[i][j] == True:
                rowCount += 1
            # 세로 빙고 체크
            if status[j][i] == True:
                colCount += 1
        
        if rowCount == 5:
            bingo += 1
        if colCount == 5:
            bingo += 1
    
    if leftDiaCount == 5:
        bingo += 1
    if rightDiaCount == 5:
        bingo += 1
    
    return bingo

graph = [list(map(int, input().split())) for _ in range(5)]
status = [[False] * 5 for _ in range(5)]

answer = []
for _ in range(5):
    answer.extend(list(map(int, input().split())))

bingo = 0
count = 0

for value in answer:
    count += 1
    for i in range(5):
        for j in range(5):
            if graph[i][j] == value:
                status[i][j] = True
    
    if bingo_check() >= 3:
        break

print(count)