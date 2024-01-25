import sys

input = sys.stdin.readline

n = int(input())

end = 1
count = 1
while True:
    if n == 1:
        print(1)
        break

    if (end + count * 6) >= n:
        print(count+1)
        break
    else:
        end += count * 6
        count += 1
