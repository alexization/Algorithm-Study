import sys

input = sys.stdin.readline

s, p = map(int, input().split())
dna = list(input().strip())
a, c, g, t = map(int, input().split())
seq_dict = {'A': a, 'C': c, 'G': g, 'T': t}
temp_pw = {'A': 0, 'C': 0, 'G': 0, 'T': 0}
count = 0

for i in range(p):
    temp_pw[dna[i]] += 1

status = True
if seq_dict['A'] > temp_pw['A']:
    status = False
if seq_dict['C'] > temp_pw['C']:
    status = False
if seq_dict['G'] > temp_pw['G']:
    status = False
if seq_dict['T'] > temp_pw['T']:
    status = False

if status == True:
    count += 1

for i in range(s-p):
    seq = dna[i+p]
    value = dna[i]

    temp_pw[seq] += 1
    temp_pw[value] -= 1

    if seq_dict['A'] > temp_pw['A']:
        continue
    if seq_dict['C'] > temp_pw['C']:
        continue
    if seq_dict['G'] > temp_pw['G']:
        continue
    if seq_dict['T'] > temp_pw['T']:
        continue
    
    count += 1
    
print(count)