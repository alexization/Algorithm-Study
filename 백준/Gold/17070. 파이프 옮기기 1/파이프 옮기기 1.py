import sys

input = sys.stdin.readline
N = int(input())
house = []
for _ in range(N):
    house.append(list(map(int, input().split())))
total = 0


def dfs(x, y, direction):
    global total
    if x == N - 1 and y == N - 1 and house[x][y] == 0:
        total += 1
        return
    if direction == 0 or direction == 2:
        if y  < N - 1:
            if house[x][y + 1] == 0:
                dfs(x, y + 1, 0)
    if direction == 1 or direction == 2:
        if x < N - 1:
            if house[x + 1][y] == 0:
                dfs(x + 1, y, 1)
    if direction == 0 or direction == 1 or direction == 2:
        if x < N - 1 and y < N - 1:
            if house[x + 1][y] == 0 and house[x][y + 1] == 0 and house[x + 1][y + 1] == 0:
                dfs(x + 1, y + 1, 2)


dfs(0, 1, 0)
print(total)