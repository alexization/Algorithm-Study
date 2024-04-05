import sys
input = sys.stdin.readline

board = [list(map(int, input().strip())) for _ in range(9)]

def check_square(col, row, value):
    row = (row // 3) * 3
    col = (col // 3) * 3
    for i in range(col, col+3):
        for j in range(row, row+3):
            if board[i][j] == value:
                return True
    return False

def check_col(col, value):
    for i in range(9):
        if board[col][i] == value:
            return True
    return False

def check_row(row, value):
    checkSet = set()
    for i in range(9):
        if board[i][row] == value:
            return True
    return False

def dfs(depth):
    if depth == len(zeros):
        for i in range(9):
            print(''.join(map(str, board[i])))
        exit()
    
    x, y = zeros[depth]

    for i in range(1, 10):
        if check_row(y, i):
            continue
        if check_col(x, i):
            continue
        if check_square(x, y, i):
            continue
        board[x][y] = i
        dfs(depth+1)
        board[x][y] = 0

zeros = []
for i in range(9):
    for j in range(9):
        if board[i][j] == 0:
            zeros.append((i, j))

dfs(0)