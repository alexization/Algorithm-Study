import sys

input = sys.stdin.readline

n = int(input())

prev = [0, 0]
score = [0, 0]
time_a, time_b = 0, 0

for _ in range(n):
    team, time = input().split()
    min, sec = map(int, time.split(':'))
    time = min * 60 + sec

    if team == '1':
        score[0] += 1
    else:
        score[1] += 1

    if score[0] == score[1]:
        if prev[0] == 1:
            time_a += time - prev[1]
        else:
            time_b += time - prev[1]
        prev[0] = 0

    elif score[0] > score[1]:
        if prev[0] == 0:
            prev[0] = 1
            prev[1] = time
    else:
        if prev[0] == 0:
            prev[0] = 2
            prev[1] = time

if prev[0] == 1:
    time_a += 48*60 - prev[1]
elif prev[0] == 2:
    time_b += 48*60 - prev[1]

print("%02d:%02d" %(time_a // 60, time_a % 60))
print("%02d:%02d" %(time_b // 60, time_b % 60))