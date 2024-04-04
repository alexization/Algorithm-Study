import sys
input = sys.stdin.readline

n, m = map(int, input().split())
peoples = dict()
for _ in range(n):
    peoples[input().strip()] = 0

for _ in range(m):
    value = input().strip()
    if value in peoples:
        peoples[value] += 1
    
result = []
for item, value in peoples.items():
    if value > 0:
        result.append(item)
result.sort()
print(len(result))
for i in result:
    print(i)