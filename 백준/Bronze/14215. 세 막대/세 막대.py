sticks = list(map(int, input().split()))
sticks.sort(reverse=True)

if sticks[1] + sticks[2] <= sticks[0]:
    sticks[0] = (sticks[1] + sticks[2]) - 1

print(sum(sticks))