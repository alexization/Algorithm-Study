n, m = map(int, input().split())
arr = [i for i in range(n+1)]

for _ in range(m):
    i, j = map(int, input().split())
    arr[i], arr[j] = arr[j], arr[i]

strArr = list(map(str, arr))
print(' '.join(strArr[1:]))