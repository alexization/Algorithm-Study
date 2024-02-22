import heapq
import sys
input = sys.stdin.readline

n = int(input())
cards = []

for _ in range(n):
    heapq.heappush(cards, int(input()))

result = 0
for i in range(n-1):
    valueLeft = heapq.heappop(cards)
    valueRight = heapq.heappop(cards)
    value = valueLeft + valueRight
    result += value
    heapq.heappush(cards, value)

print(result)