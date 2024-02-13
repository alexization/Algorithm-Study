import sys

N = int(sys.stdin.readline())

ins = list(map(int, sys.stdin.readline().strip().split()))
pos = list()
result = list()

for i in range (N):
    result.append('0')
    
now = 1

pos.append(0)

while(now != N):
    if (len(pos) != 0):
        if(ins[pos[len(pos)-1]] < ins[now]):
            result[pos[len(pos)-1]] = str(ins[now])
            pos.pop()
        else:
            pos.append(now)
            now += 1
    else:
        pos.append(now)
        now += 1
        
while(len(pos) != 0):
    result[pos[len(pos)-1]] = '-1'
    pos.pop()
    
print(' '.join(result))