from copy import deepcopy
import sys
input = sys.stdin.readline

n = int(input())
board = [list(map(int, input().split())) for _ in range(n)]

def move(board, mode):
    if mode == 'up':
        for j in range(n):
            point = 0
            for i in range(1, n):
                if board[i][j]:
                    tmp = board[i][j]
                    board[i][j] = 0
                    if tmp == board[point][j]:
                        board[point][j] = tmp * 2
                        point += 1
                    elif board[point][j] == 0:
                        board[point][j] = tmp
                    else:
                        point += 1
                        board[point][j] = tmp
    
    elif mode == 'down':
        for j in range(n):
            point = n - 1
            for i in range(n-2, -1, -1):
                if board[i][j]:
                    tmp = board[i][j]
                    board[i][j] = 0
                    if tmp == board[point][j]:
                        board[point][j] = tmp * 2
                        point -= 1
                    elif board[point][j] == 0:
                        board[point][j] = tmp
                    else:
                        point -= 1
                        board[point][j] = tmp

    elif mode == 'left':
        for i in range(n):
            point = 0
            for j in range(1, n):
                if board[i][j]:
                    tmp = board[i][j]
                    board[i][j] = 0
                    if tmp == board[i][point]:
                        board[i][point] = tmp * 2
                        point += 1
                    elif board[i][point] == 0:
                        board[i][point] = tmp
                    else:
                        point += 1
                        board[i][point] = tmp
        
    else:
        for i in range(n):
            point = n - 1
            for j in range(n-2, -1, -1):
                if board[i][j]:
                    tmp = board[i][j]
                    board[i][j] = 0
                    if tmp == board[i][point]:
                        board[i][point] = tmp * 2
                        point -= 1
                    elif board[i][point] == 0:
                        board[i][point] = tmp
                    else:
                        point -= 1
                        board[i][point] = tmp
    return board

result = []
max_num = -1
def dfs(board, count):
    global max_num
    if count == 5:
        for i in range(n):
            for j in range(n):
                max_num = max(max_num, board[i][j])
        return
    
    for m in ['up', 'down', 'left', 'right']:
        tmp_board = move(deepcopy(board), m)
        dfs(tmp_board, count+1)

dfs(board, 0)
print(max_num)