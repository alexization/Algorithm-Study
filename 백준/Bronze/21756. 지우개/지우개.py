N = int(input())
arr = list(range(1, N+1))

while len(arr) != 1:
    arr2 = []
    for a in arr[1::2]:
        arr2.append(a)
    arr = arr2

print(arr[0])
