import sys

input = sys.stdin.readline
p = int(input().strip())

for _ in range(p):
    result = []
    count = 0
    data = list(map(int, input().split()))
    
    result.append(data[1])
    for i in range(2, 21):
        for j in range(len(result)):                
            if result[j] > data[i]:
                result.insert(j, data[i])
                count += len(result) - (j+1)
                break
            if j == len(result) - 1:
                result.append(data[i])

    print(data[0], count)