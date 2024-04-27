def cut(paper, x1, x2, y1, y2):
    
    global count_blue
    global count_white
    blue = 0
    white = 0

    for i in range(x1, x2):
        if paper[i][y1:y2].count(0) == 0:
            blue = 1
        
        elif paper[i][y1:y2].count(1) == 0:
            white = 1
        
        else:
            blue = 1
            white = 1

    if blue == 1 and white == 0:
        count_blue += 1
        return

    elif white == 1 and blue == 0:
        count_white += 1
        return
    
    else:
        cut(paper, x1, (x1+x2)//2, y1, (y1+y2)//2)
        cut(paper, x1, (x1+x2)//2, (y1+y2)//2, y2)
        cut(paper, (x1+x2)//2, x2, y1, (y1+y2)//2)
        cut(paper, (x1+x2)//2, x2, (y1+y2)//2, y2)


N = int(input())
count_blue = 0
count_white = 0
paper = [list(map(int, input().split())) for _ in range(N)]

cut(paper, 0, N, 0, N)
print(count_white)
print(count_blue)