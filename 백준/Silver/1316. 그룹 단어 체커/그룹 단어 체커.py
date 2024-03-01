import sys
input = sys.stdin.readline

n = int(input())
words = []
for _ in range(n):
    words.append(input())

count = 0
for word in words:
    status = True
    checkSet = set()
    prev = word[0]
    checkSet.add(prev)
    for i in range(1, len(word)):
        if prev != word[i]:
            prev = word[i]
            if prev in checkSet:
                status = False
                break
            checkSet.add(prev)
    if status == True:
        count += 1

print(count)