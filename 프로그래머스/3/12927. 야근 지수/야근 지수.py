import heapq

def solution(n, works):
    answer = 0
    maxHeap = []
    
    for i in works:
        heapq.heappush(maxHeap, (-i, i))
    
    for i in range(n):
        value = heapq.heappop(maxHeap)[1] - 1
        heapq.heappush(maxHeap, (-value, value))
    
    array = list(maxHeap)
    for i in array:
        if i[1] <= 0:
            continue
        answer += i[1] ** 2
    return answer