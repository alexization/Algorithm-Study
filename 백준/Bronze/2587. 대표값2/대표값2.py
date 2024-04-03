numList = []
for _ in range(5):
    numList.append(int(input()))

numList.sort()
numSum = sum(numList)

print(numSum // 5)
print(numList[2])