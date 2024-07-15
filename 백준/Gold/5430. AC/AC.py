import sys
from collections import deque

T = int(sys.stdin.readline())

while T:
    
    flg = 0
    rev = 0
    result = deque()
    
    p = sys.stdin.readline().strip()
    cnt = int(sys.stdin.readline())
    val = sys.stdin.readline().strip()
    
    stk = deque(val[1:-1].split(','))
    
    for i in range(len(p)):
        
        if p[i] == 'R':
            rev += 1
        elif p[i] == 'D':
            if len(stk) == 0 or cnt == 0:
                flg = 1
                print('error')
                break
            elif rev % 2 == 0:
                stk.popleft()
            elif rev % 2 != 0:
                stk.pop()
    for i in range(len(stk)):
        if rev % 2 != 0:
            result.append(stk.pop())
        else:
            result.append(stk.popleft())
    if flg == 0:        
        print('['+','.join(result)+']')
        
    T -= 1