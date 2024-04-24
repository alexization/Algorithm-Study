t = int(input())
for _ in range(t):
    h, w, n = map(int, input().split())
    col = (n % h)

    if col == 0:
        result = str(h)
        row = n // h
    else:
        result = str(col)
        row = (n // h) + 1

    if row < 10:
        result += '0'
    result += str(row)
    print(result)