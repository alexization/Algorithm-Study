import sys
input = sys.stdin.readline

n = int(input())
scores = []
for _ in range(n):
    scores.append(int(input()))

high_score = scores[-1]
result = 0
for i in range(n-2, -1, -1):
    if high_score > scores[i]:
        high_score = scores[i]
        continue
    result += (scores[i] - high_score) + 1
    high_score -= 1

print(result)