import sys
input = sys.stdin.readline

n, m = map(int, input().split())

dnas = []
for _ in range(n):
    dnas.append(list(input().strip()))

result_dna = ''
distance = 0
for i in range(m):
    count_dict = {'A':0, 'T':0, 'C':0, 'G':0}
    for j in range(n):
        count_dict[dnas[j][i]] += 1

    temp = []
    for key, value in count_dict.items():
        distance += value
        temp.append((key, value))
    temp.sort(key=lambda x : (-x[1], x[0]))
    result_dna += temp[0][0]
    distance -= temp[0][1]

print(result_dna)
print(distance)