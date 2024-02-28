import sys
from collections import deque
input = sys.stdin.readline

t = int(input())
for _ in range(t):
    n, m = map(int, input().split())
    priority = list(map(int, input().split()))
    p = deque()
    for idx, pri in enumerate(priority):
        p.append((pri, idx))
    
    count = 0
    while p:
        max_pri = -1
        status = False
        for i in p:
            if i[0] > max_pri:
                max_pri = i[0]
        while True:
            if p[0][0] == max_pri:
                count += 1
                if p[0][1] == m:
                    status = True

                p.popleft()
                break
            else:
                p.append(p.popleft())
        if status == True:
            break
        
    print(count)
