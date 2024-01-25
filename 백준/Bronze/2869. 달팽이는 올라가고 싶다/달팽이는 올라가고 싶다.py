import sys
from math import ceil

input = sys.stdin.readline

a, b, v = map(int, input().split())

result = ceil((v-a)/(a-b)) + 1

print(result)
