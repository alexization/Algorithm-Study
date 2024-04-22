n = int(input())

count = 0
for i in range(1, n+1):
    strNum = list(str(i))
    value = 0
    for num in strNum:
        value += int(num)
    if i % value == 0:
        count += 1

print(count)