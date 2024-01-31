import sys

input = sys.stdin.readline

n = int(input())
data = [-1]
s1 = list(map(int, input().split()))
data.extend(s1)

t = int(input())

for _ in range(t):
    s, switch = map(int, input().split())

    if s == 1:
        for i in range(switch, n+1, switch):
            if data[i] == 1:
                data[i] = 0
            else:
                data[i] = 1
    
    else:
        count = 0
        for i in range(1, (n+1)//2):
            if (switch - i) > 0 and (switch + i) < (n + 1):
                if data[switch - i] != data[switch + i]:
                    break
                else:
                    count += 1

            else:
                break
        
        if data[switch] == 0:
            data[switch] = 1
        else:
            data[switch] = 0
        
        if count != 0:
            for i in range(1, count + 1):
                if data[switch - i] == 0:
                    data[switch + i], data[switch - i] = 1, 1
                else:
                    data[switch + i], data[switch - i] = 0, 0
                    
result = list(map(str, data[1:]))
count = n // 20

for i in range(count+1):
    print(' '.join(result[i*20:(i+1)*20]))
