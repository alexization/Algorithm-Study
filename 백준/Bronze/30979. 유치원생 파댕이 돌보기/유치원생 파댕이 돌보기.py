t = int(input())
n = int(input())
candys = list(map(int, input().split()))

if t <= sum(candys):
    print("Padaeng_i Happy")
else:
    print("Padaeng_i Cry")