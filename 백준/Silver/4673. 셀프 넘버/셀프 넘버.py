selfNum = [True] * 10001

for i in range(1, 10001):
    strNum = list(str(i))
    value = i
    for num in strNum:
        value += int(num)
    if value < 10001:
        selfNum[value] = False

for i in range(1, 10001):
    if selfNum[i]:
        print(i)