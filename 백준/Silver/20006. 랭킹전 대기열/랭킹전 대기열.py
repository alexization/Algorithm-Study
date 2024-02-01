import sys
input = sys.stdin.readline

p, m = map(int, input().split())

room = []
for i in range(p):
    rate, name = input().split()

    if len(room) == 0:
        room.append([[int(rate), name]])
        continue

    in_status = False
    for j in range(len(room)):
        if len(room[j]) >= m:
            continue
        else:
            if room[j][0][0] - 10 <= int(rate) <= room[j][0][0] + 10:
                room[j].append([int(rate), name])
                in_status = True
                break
    
    if in_status == False:
        room.append([[int(rate), name]])

for i in room:
    i.sort(key=lambda x: x[1])
    if len(i) < m:
        print("Waiting!")
    else:
        print("Started!")
    for j in i:
        print(j[0], j[1])