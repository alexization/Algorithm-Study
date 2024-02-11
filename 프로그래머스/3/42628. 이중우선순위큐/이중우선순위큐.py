import heapq

def solution(operations):
    answer = []
    heap = []
    
    for operation in operations:
        o, value = operation.split()
        if o == 'I':
            heapq.heappush(heap, int(value))
        elif o == 'D':
            if value == '-1' and len(heap) > 0:
                heapq.heappop(heap)
            elif value == '1' and len(heap) > 0:
                heap.pop()
                
    if len(heap) == 0:
        answer = [0, 0]
    elif len(heap) == 1:
        answer = [heap[0], heap[0]]
    else:
        answer.append(max(heap))
        answer.append(heap[0])
        
    return answer