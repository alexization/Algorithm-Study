import sys
input = sys.stdin.readline
n, m = map(int, input().split())

words = dict()
for _ in range(n):
    word = input().strip()
    if len(word) >= m:
        if word not in words:
            words[word] = [1, len(word)]
        else:
            words[word][0] += 1

words = list(words.items())            
words.sort(key=lambda x: (-x[1][0], -x[1][1], x[0]))
for word in words:
    print(word[0])