import sys
input = sys.stdin.readline

n, game = map(str, input().split())
gameDict = {'Y':1, 'F':2, 'O':3}
players = set()
for _ in range(int(n)):
    players.add(input().strip())

print(len(players) // gameDict[game])