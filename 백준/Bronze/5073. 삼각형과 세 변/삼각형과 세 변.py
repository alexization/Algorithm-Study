import sys
input = sys.stdin.readline

while True:
    temp = list(map(int, input().split()))
    check_set = set(temp)
    if len(check_set) == 1:
        if 0 in check_set:
            break
        print("Equilateral")
        continue

    temp.sort(reverse=True)
    longValue = temp[0]
    a, b = temp[1], temp[2]
    if (a + b) <= longValue:
        print("Invalid")
        continue

    if len(check_set) == 2:
        print("Isosceles")
        continue

    else:
        print("Scalene")
        continue