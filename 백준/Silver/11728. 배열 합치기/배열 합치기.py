import sys
input = sys.stdin.readline

n, m = map(int, input().split())
arrN = list(map(int, input().split()))
arrM = list(map(int, input().split()))

resultArr = []

idxN, idxM = 0, 0
while idxN != n or idxM != m:
    if arrN[idxN] <= arrM[idxM]:
        resultArr.append(arrN[idxN])
        idxN += 1
    else:
        resultArr.append(arrM[idxM])
        idxM += 1
    
    if idxN == n:
        while idxM != m:
            resultArr.append(arrM[idxM])
            idxM += 1
    elif idxM == m:
        while idxN != n:
            resultArr.append(arrN[idxN])
            idxN += 1

print(*resultArr)