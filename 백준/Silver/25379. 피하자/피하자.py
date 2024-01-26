N = int(input())
arr = list(map(int, input().split()))

cnt_odd_left = 0
cnt_odd = 0
cnt_even_left = 0
cnt_even = 0

for a in arr:
    if a % 2 == 1:
        cnt_odd += 1
        cnt_even_left += cnt_even
    else:
        cnt_even += 1
        cnt_odd_left += cnt_odd

print(min(cnt_odd_left, cnt_even_left))
