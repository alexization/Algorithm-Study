n = int(input())

result = []
if n > 1:
    students = list(map(int, input().split()))
    b, c = map(int, input().split())
    for student in students:
        count = 1
        if student - b > 0:
            student -= b
            if student % c == 0:
                count += (student // c)
            else:
                count += (student // c) + 1
        result.append(count)
    print(sum(result))

else:
    student = int(input())
    b, c = map(int, input().split())
    count = 1
    if student - b > 0:
        student -= b
        count = count + (student // c) + 1
    print(count)