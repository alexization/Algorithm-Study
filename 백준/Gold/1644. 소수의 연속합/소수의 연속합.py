n = int(input())

prime = [True] * (n+1)
prime[0], prime[1] = False, False

arr = []
for i in range(2, n+1):
    if prime[i]:
        arr.append(i)
        for j in range(i*2, n+1, i):
            prime[j] = False

length = len(arr)
head = 0
tail = 0
value = 0
count = 0

while tail <= head:
    if n > value:
        if head == length:
            break
        value += arr[head]
        head += 1
    else:
        value -= arr[tail]
        tail += 1
    
    if value == n:
        count += 1

print(count)