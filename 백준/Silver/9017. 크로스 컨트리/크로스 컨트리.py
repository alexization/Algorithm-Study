import sys

input = sys.stdin.readline

t = int(input())

for _ in range(t):
    n = int(input())
    d = dict()
    five_d = dict()
    data = list(map(int, input().split()))
    data_list = list(set(data))
    result = []
    remove_list = []
    
    for i in data_list:
        if data.count(i) < 6:
            remove_list.append(i)
    
    result = [i for i in data if i not in remove_list]
    for i in result:
        d[i] = [0, 0, 0]
        five_d[i] = [0, 0]

    score = 1
    for i in range(len(result)):
        if d[result[i]][1] < 4:
            d[result[i]][0] += score
            d[result[i]][1] += 1
        if five_d[result[i]][1] <= 4:
            five_d[result[i]][0] += score
            d[result[i]][2] += score
            five_d[result[i]][1] += 1
        score += 1
    
    final = []

    for team, score in d.items():
        final.append([team, score[0], score[2]])
    final.sort(key=lambda x: (x[1], x[2]))
    print(final[0][0])